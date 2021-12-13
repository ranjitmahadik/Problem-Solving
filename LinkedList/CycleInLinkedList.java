package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CycleInLinkedList {
    private static boolean hasCycleBruteForce(ListNode head) {
        Map<ListNode, Boolean> lookup = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (lookup.containsKey(temp)) {
                return true;
            }
            lookup.put(temp, true);
            temp = temp.next;
        }
        return false;
    }

    private static boolean hasCycleOptimal(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slowPtr = head;
        ListNode fastPtr = head.next.next;
        while (fastPtr != null && fastPtr.next != null) {
            if (slowPtr == fastPtr) return true;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return false;
    }

    private static ListNode findCycleNode(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slowPtr = head;
        ListNode fastPtr = head.next.next;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                slowPtr = head;
                while (slowPtr != fastPtr) {
                    slowPtr = slowPtr.next;
                    fastPtr = fastPtr.next;
                }
                return fastPtr;
            }
        }
        return null;
    }

}
