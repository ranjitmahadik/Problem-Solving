package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class IntersectionNode {
    //bruteforce
    private static void findIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Boolean> lookup = new HashMap<>();
        ListNode tempA = headA;
        while (tempA != null) {
            lookup.put(headA, true);
            tempA = tempA.next;
        }
        tempA = headB;
        while (tempA != null) {
            if (lookup.containsKey(tempA)) {
                break;
            }
            tempA = tempA.next;
        }
        System.out.println("Intersection Node is = " + tempA);
    }

    private static void findIntersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return;

        ListNode A = headA;
        ListNode B = headB;

        while (A != null && B != null) {
            A = A.next == null ? headB : A.next;
            B = B.next == null ? headA : B.next;
        }

        System.out.println(A.val);
    }
}
