import java.util.HashMap;

/**
 * Created by Nikhil on 12/24/16.
 */

/**
 * A linked list is given such that each node contains an additional
 * random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }


    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        HashMap<RandomListNode, RandomListNode> hmap = new HashMap<>();
        RandomListNode node = head;
        while (node != null) {
            hmap.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while (node != null) {
            hmap.get(node).next = hmap.get(node.next);
            hmap.get(node).random = hmap.get(node.random);
            node = node.next;

        }
        return hmap.get(head);
    }
}
