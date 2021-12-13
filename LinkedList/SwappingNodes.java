package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class SwappingNodes {

    /**
     * we traverse list only one time hence time complexity would be O(n) assuming hashmap insertions takes only O(1) time.
     * and space complexity would be O(n) since we'r storing all nodes in it.
     */
    private static ListNode swapNodes(ListNode head, final int K) {
        Map<Integer, ListNode> lookup = new HashMap<>();
        ListNode temp = head;
        int count = 1;
        while (temp != null) {
            lookup.put(count, temp);
            count++;
            temp = temp.next;
        }

        int valFromFront = lookup.get(K).val;
        int valFromBack = lookup.get(count - K).val;

        lookup.get(K).val = valFromBack;
        lookup.get(count - K).val = valFromFront;

        return head;
    }


    private static ListNode swapNodesOptimal(ListNode head, final int K) {
        ListNode frontNode = head, slow = head, fast = head;
        int count = 1;
        while (count != K) {
            count++;
            fast = fast.next;
        }

        frontNode = fast;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        int frontNodeVal = frontNode.val;
        int backNodeVal = slow.val;

        frontNode.val = backNodeVal;
        slow.val = frontNodeVal;

        return head;
    }

    public static void main(String[] args) {
        ListNode.showNodes(swapNodes(ListNode.getList(), 2));
        ListNode.showNodes(swapNodesOptimal(ListNode.getList(),2));
    }
}
