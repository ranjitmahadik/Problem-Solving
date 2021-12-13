package LinkedList;

public class OddEvenList {
    private static ListNode convertToOddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddParent = new ListNode(-1);
        ListNode dummyOdd = oddParent;
        ListNode evenParent = new ListNode(-1);
        ListNode dummyEven = evenParent;

        ListNode temp = head;

        int count = 1;
        while (temp != null) {
            if (count % 2 == 0) {
                dummyEven.next = temp;
                dummyEven = dummyEven.next;
            } else {
                dummyOdd.next = temp;
                dummyOdd = dummyOdd.next;
            }
            count++;
            temp = temp.next;
        }
        dummyEven.next = null;
        dummyOdd.next = evenParent.next;
        return oddParent.next;
    }

    public static void main(String[] args) {
        ListNode.showNodes(convertToOddEvenList(ListNode.getList()));
    }
}
