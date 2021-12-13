package LinkedList;

public class PalindromeLinkedList {

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;  //5
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private static boolean isPalin(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //slowPtr points to middle of linked list in case of odd and ceil(n/2) in case of even.
        ListNode secondHalfReversed = reverse(slow);
        return isPalin(head, secondHalfReversed);
    }

    public static void main(String[] args) {
        isPalindrome(ListNode.getPalindromeList());
    }
}
