package LinkedList;

public class DeleteKthNodeFromLast {

    //approach by adding extra node at head.
    private static ListNode deleteKthNode(ListNode head, int K) {
        if (K <= 0) return head;
        ListNode fast = new ListNode(-1), slow;
        fast.next = head;
        slow = fast;
        ListNode dummyRoot = fast;
        int count = 0;
        while (count != K) {
            fast = fast.next;
            count++;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyRoot.next;
    }


    private static ListNode deleteKthNodeFromLast(ListNode head, final int K) {
        ListNode fast = head, slow = head;
        int count = 1;
        while (count != (K + 1)) {
            count++;
            fast = fast.next;
        }

        if (fast == null) return head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getList();
        ListNode.showNodes(deleteKthNode(head, 2));
    }
}
