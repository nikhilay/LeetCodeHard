/**
 * Created by Nikhil on 1/26/17.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value. So the median is the mean of the two middle value.
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 */
/**
 * Inspired from
 * https://discuss.leetcode.com/topic/27506/easy-to-understand-double-heap-solution-in-java/2
 */


public class FindMedianFromDataStream {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if(minHeap.size()==0 && maxHeap.size()==0){
            minHeap.add(num);
        }else if(minHeap.size()>maxHeap.size()){
            if(num>minHeap.peek()){
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }else{
                maxHeap.add(num);
            }

        }else if(maxHeap.size()>minHeap.size()) {
            if (num < maxHeap.peek()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
            }
        }else{
            if(num>minHeap.peek()){
                minHeap.add(num);
            }else{
                maxHeap.add(num);
            }
        }

    }

    public double findMedian() {
        if(minHeap.size()==0 && maxHeap.size()==0) return 0;
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return (minHeap.peek()+maxHeap.peek())/(2.0);

    }
}
