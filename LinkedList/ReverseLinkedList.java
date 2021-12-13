package LinkedList;

public class ReverseLinkedList {
    /**
     * 1 => 2 => 3 => 4
     * 4 => 3
     */
    private static ListNode revMainPointer;

    private static void reverseList(ListNode currentNode, ListNode prevNode) {
        if (currentNode.next == null) {
            currentNode.next = prevNode;
            revMainPointer = currentNode;
            return;
        }
        reverseList(currentNode.next, currentNode);
        currentNode.next = prevNode;
    }

    /**
     * 1 => 2 => 3 => 4
     */
    private static void iterativeReverseList(ListNode root) {
        ListNode temp, prev = null;
        temp = root;

        while (temp != null) {
            ListNode currNode = temp;
            temp = temp.next;
            currNode.next = prev;
            prev = currNode;
        }

        ListNode.showNodes(prev);
    }




    public static void main(String[] args) {
//        ListNode root = ListNode.getList();
//        ListNode.showNodes(root);
////        reverseList(root, null);
////        ListNode.showNodes(revMainPointer);
//        iterativeReverseList(root);


    }
}
