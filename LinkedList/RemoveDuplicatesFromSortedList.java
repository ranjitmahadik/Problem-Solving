package LinkedList;


public class RemoveDuplicatesFromSortedList {

    /**
     * -1 => 9 => 9 => 9 => 9 => 9
     * i
     */
    private static void removeDuplicates(ListNode root) {
        ListNode finalHead = new ListNode(Integer.MAX_VALUE), tempHead;
        finalHead.next = root;
        tempHead = finalHead;

        while (tempHead.next != null) {
            if (tempHead.val == tempHead.next.val) {
                tempHead.next = tempHead.next.next;
                continue;
            }
            tempHead = tempHead.next;
        }

        ListNode.showNodes(finalHead.next);
    }

    public static void main(String[] args) {
        removeDuplicates(ListNode.getTestCase());
    }
}
