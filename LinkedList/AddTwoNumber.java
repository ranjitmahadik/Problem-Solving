package LinkedList;

public class AddTwoNumber {
    /**
     * 9   9   9   9   9   9   9
     * 9   9   9   9
     * ---------------------------
     * 18 % 10 = 8
     */
    private static void addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ansNode = new ListNode(-1);
        ListNode ansNodeRoot = ansNode;

        while (l1 != null && l2 != null) {
            int firstNodeNumber = l1.val;
            int secondNodeNumber = l2.val;

            int sum = firstNodeNumber + secondNodeNumber + carry;
            ansNode.next = new ListNode(sum % 10);
            if (sum >= 10) carry = sum / 10;
            else carry = 0;

            ansNode = ansNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = (l1.val + carry);

            if (sum >= 10) carry = sum / 10;
            else carry = 0;

            ansNode.next = new ListNode(sum % 10);
            ansNode = ansNode.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = (l2.val + carry);

            if (sum >= 10) carry = sum / 10;
            else carry = 0;

            ansNode.next = new ListNode(sum % 10);
            ansNode = ansNode.next;
            l2 = l2.next;
        }

        if (carry > 0) ansNode.next = new ListNode(1);

        ListNode.showNodes(ansNodeRoot.next);
    }

    /**
     * 1 => 2 =>     3   => 4 => 5
     * 2  <= 3
     */
    private static ListNode reverse(ListNode l1) {
        ListNode prev = null, temp = l1;

        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode root = ListNode.getTestCase();
        ListNode root1 = ListNode.getTestCase2();

        ListNode.showNodes(root);
        ListNode.showNodes(root1);

        addTwoNumbers(root, root1);


        //add Two Numbers II
        root1 = reverse(root1);
        root = reverse(root);
        addTwoNumbers(root, root1);
    }
}
