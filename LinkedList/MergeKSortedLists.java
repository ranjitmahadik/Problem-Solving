package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    private static ListNode mergeKList(ListNode[] nodeList) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (int i = 0; i < nodeList.length; i++) {
            ListNode currNode = nodeList[i];
            while (currNode != null) {
                pq.add(currNode);
                currNode = currNode.next;
            }
        }

        ListNode dummyRes = new ListNode(-1);
        ListNode result = dummyRes;
        while (!pq.isEmpty()) {
            dummyRes.next = pq.poll();
            dummyRes = dummyRes.next;
            dummyRes.next = null;
        }
        return result.next;
    }

    public static void main(String[] args) {
    }
}
