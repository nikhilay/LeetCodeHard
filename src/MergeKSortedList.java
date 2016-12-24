import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Nikhil on 12/24/16.
 */

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

/**
 * Inspired from
 * https://discuss.leetcode.com/topic/2780/a-java-solution-based-on-priority-queue
 */
public class MergeKSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        if(lists==null ||lists.length==0) return dummy.next;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return o1.val - o2.val;
            }



        });

        for(ListNode node:lists){
            if(node!=null) pq.add(node);
        }
        ListNode tail = dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if(tail.next!=null){
                pq.add(tail.next);
            }


        }

        return dummy.next;

    }
}
