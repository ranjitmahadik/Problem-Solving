package LinkedList;

public class MergeSortLinkedList {

    /***
     *          1   =>  4   =>  7
     *          2   =>  3
     *
     *
     * */

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(-1);
        ListNode finalResult = result;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                result.next = head1;
                head1 = head1.next;
            } else {
                result.next = head2;
                head2 = head2.next;
            }
            result = result.next;
        }

        while (head1 != null) {
            result.next = head1;
            head1 = head1.next;
            result = result.next;
        }

        while (head2 != null) {
            result.next = head2;
            head2 = head2.next;
            result = result.next;
        }

        return finalResult.next;
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middleNode = findMid(head);
        ListNode nextNode = middleNode.next;
        middleNode.next = null;

        ListNode leftSide = mergeSort(head);
        ListNode rightSide = mergeSort(nextNode);

        return merge(leftSide, rightSide);
    }


    public static void main(String[] args) {
        ListNode root = ListNode.getUnsortedList();
        ListNode.showNodes(mergeSort(root));
    }
}
