package LinkedList;


/**
 * we can re-use solution from reverse nodes in kgroup with fixed k of 2.
 */
public class SwapNodesInPair {
    /**
     * 1 => 2 => 3 => 4
     * 2 => 1 => 3 =>
     */
    private static ListNode swapNodes(ListNode head) {
        ListNode currentNode = new ListNode(-1);
        currentNode.next = head;
        ListNode mainNode = currentNode;

        while (currentNode != null && currentNode.next != null && currentNode.next.next != null) {
            ListNode firstNode = currentNode.next;              //1
            ListNode secondNode = currentNode.next.next;        //2

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            currentNode.next = secondNode;

            currentNode = firstNode;
        }

        return mainNode.next;
    }

    public static void main(String[] args) {
        swapNodes(ListNode.getList());
    }
}
