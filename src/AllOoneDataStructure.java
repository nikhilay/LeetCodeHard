/**
 * Created by Nikhil on 1/25/17.
 */

import java.util.HashMap;
import java.util.HashSet;

/**
 * Implement a data structure supporting the following operations:
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a
 * non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1.
 * If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/65634/java-ac-all-strict-o-1-not-average-o-1-easy-to-read/5
 */
public class AllOoneDataStructure {

    class Bucket {
        int count;
        HashSet<String> keySet;
        Bucket next;
        Bucket prev;

        Bucket(int count) {
            this.count = count;
            keySet = new HashSet<>();
        }

    }

    HashMap<String, Integer> countMap;
    HashMap<Integer, Bucket> bucketMap;
    Bucket head;
    Bucket tail;

    /**
     * Initialize your data structure here.
     */
    public AllOoneDataStructure() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next=tail;
        tail.prev = head;
        countMap = new HashMap<>();
        bucketMap = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (countMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            countMap.put(key, 1);
            if (head.next.count != 1) {
                //create new bucket
                addNewBucket(head, new Bucket(1));
            }
            head.next.keySet.add(key);

            bucketMap.put(1, head.next);
        }

    }


    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (countMap.containsKey(key)) {
            int count = countMap.get(key);
            if (count == 1) {
                countMap.remove(key);
                removeKeyFromBucket(bucketMap.get(count), key);
            } else {
                changeKey(key, -1);
            }
        }

    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return tail.prev==head?"":tail.prev.keySet.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return head.next==tail?"":head.next.keySet.iterator().next();
    }


    private void changeKey(String key, int increment) {
        int oldVal = countMap.get(key);
        int newVal = oldVal + increment;
        countMap.put(key,newVal);
        Bucket currBucket = bucketMap.get(oldVal);
        Bucket newbucket = null;
        if (bucketMap.containsKey(newVal)) {
            newbucket = bucketMap.get(newVal);

        } else {
            newbucket = new Bucket(newVal);
            bucketMap.put(newVal, newbucket);
            addNewBucket(increment == 1 ? currBucket : currBucket.prev, newbucket);
        }
        newbucket.keySet.add(key);
        removeKeyFromBucket(currBucket, key);
    }

    private void removeKeyFromBucket(Bucket currBucket, String key) {
        currBucket.keySet.remove(key);
        if (currBucket.keySet.size() == 0) {
            removeBucket(currBucket);
            bucketMap.remove(currBucket.count);

        }

    }

    private void removeBucket(Bucket currBucket) {
        currBucket.prev.next = currBucket.next;
        currBucket.next.prev = currBucket.prev;
        currBucket.next = null;
        currBucket.prev = null;
    }

    private void addNewBucket(Bucket preBucket, Bucket newBucket) {
        newBucket.next = preBucket.next;
        newBucket.prev = preBucket;
        preBucket.next.prev = newBucket;
        preBucket.next = newBucket;
    }


}
