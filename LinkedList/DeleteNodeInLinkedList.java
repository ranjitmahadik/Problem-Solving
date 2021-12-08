package LinkedList;

public class DeleteNodeInLinkedList {
    // given node in linked list delete that.
    private static void deleteGivenNode(ListNode root) {
        root.val = root.next.val;
        root.next = root.next.next;
    }

    public static void main(String[] args) {
        ListNode root = ListNode.getList();
        ListNode.showNodes(root);
        deleteGivenNode(root.next.next);
        ListNode.showNodes(root);
    }
}
