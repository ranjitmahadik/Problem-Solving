package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSubNodes {

    // think about sliding window and how this question can be solved using it.
    private static ListNode removeZeroSumSubLists(ListNode head) {
        Map<Integer, ListNode> sumList = new HashMap<>();
        ListNode temp = head;
        int runningSum = 0;
        while (temp != null) {
            runningSum += temp.val;
            if (runningSum == 0) head = temp.next;

            if (sumList.containsKey(runningSum)) {
                int currSum = runningSum;
                // find where i've found last that sum.
                sumList.get(currSum).next = temp.next;
                // since we have removed sublist with
                return removeZeroSumSubLists(head);
            } else {
                sumList.put(runningSum, temp);
            }
            temp = temp.next;
        }

        return head;
    }
}
