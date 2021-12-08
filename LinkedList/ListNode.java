package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode getList() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        return root;
    }

    public static void showNodes(ListNode root) {
        while (root.next != null) {
            System.out.print(root.val + " => ");
            root = root.next;
        }
        System.out.print(root.val + "\n");
    }

    public static ListNode getOddLengthList() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        return root;
    }

    public static ListNode getInstance1() {
        ListNode root = new ListNode(11);
        root.next = new ListNode(17);
        root.next.next = new ListNode(20);
        root.next.next.next = new ListNode(24);
        root.next.next.next.next = new ListNode(25);
        return root;
    }

    public static ListNode getInstance() {
        ListNode root = new ListNode(8);
        root.next = new ListNode(15);
        root.next.next = new ListNode(16);
        root.next.next.next = new ListNode(23);
        root.next.next.next.next = new ListNode(27);
        return root;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
