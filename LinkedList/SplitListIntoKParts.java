package LinkedList;


public class SplitListIntoKParts {
    private static void splitIntoKParts(ListNode head, final int K) {
        ListNode curr = head;
        int N = 0;
        while (curr != null) {
            curr = curr.next;
            N++;
        }

        int widthOfEachBlock = N / K, remainingNodes = N % K;
        ListNode[] nodeList = new ListNode[K];
        curr = head;
        for (int i = 0; i < K; i++) {
            ListNode headPtr = curr;
            int currentBlockWidth = widthOfEachBlock + (i < remainingNodes ? 1 : 0);
            for (int j = 0; j < currentBlockWidth - 1; j++) {
                if (curr != null) curr = curr.next;
                else break;
            }
            if (curr != null) {
                ListNode nextNode = curr.next;
                curr.next = null;
                curr = nextNode;
            }
            nodeList[i] = headPtr;
        }

        for (ListNode node : nodeList) {
            System.out.println("node = " + node);
        }

    }

    public static void main(String[] args) {
        splitIntoKParts(ListNode.getList(), 4);
    }
}
