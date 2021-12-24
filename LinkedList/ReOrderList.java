package LinkedList;

public class ReOrderList {

    private static ListNode getMiddle(ListNode root) {
        ListNode slow, fast;
        slow = fast = root;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode root) {
        ListNode prev = null, curr = root;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private static void mergeNodes(ListNode firstHalf, ListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            ListNode firstHalfNextNode = firstHalf.next;
            ListNode secondHalfNextNode = secondHalf.next;

            //first half connection done.
            firstHalf.next = secondHalf;
            secondHalf.next = firstHalfNextNode;

            //second half connection done.
            firstHalf = secondHalf.next;
            secondHalf = secondHalfNextNode;
        }
    }

    private static void reorderList(ListNode root) {
        if (root == null || root.next == null) return;
        ListNode temp = root;
        ListNode middle = getMiddle(root);
        ListNode secondHalf = middle.next;
        middle.next = null;
        secondHalf = reverse(secondHalf);

        mergeNodes(root, secondHalf);

        ListNode.showNodes(temp);
    }

    public static void main(String[] args) {
        ListNode root = ListNode.getList();
        reorderList(root);
    }
}
