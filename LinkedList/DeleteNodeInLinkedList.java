package LinkedList;

public class DeleteNodeInLinkedList {
    // given node in linked list delete that.
    private static void deleteGivenNode(ListNode root) {
        root.val = root.next.val;
        root.next = root.next.next;
    }

    private static void tp() {
        int count = 0;
        for (int i = 1; i <= 127; i++) {
            if (i % 3 == 0) count++;
        }
        System.out.println("count + \" \" + (127 / 3) = " + count + " " + (127 / 3));
    }

    public static void main(String[] args) {
//        ListNode root = ListNode.getList();
//        ListNode.showNodes(root);
//        deleteGivenNode(root.next.next);
//        ListNode.showNodes(root);
        tp();
    }
}
