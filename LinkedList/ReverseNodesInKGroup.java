package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, temp = head;

        /**
         *          1 => 2 => 3 => 4
         *
         * */
        while (temp != null) {
            ListNode nextNode = temp.next; // 3
            temp.next = prev;   // 2 => 1
            prev = temp;        // prev = 2

            temp = nextNode;
        }
        return prev;
    }


    /**
     * simple bruteforce solution would be to divide list into k groups and reverse each group and then rewire it.
     */

    private static void reverseKGroup(ListNode head, final int K) {
        List<ListNode> nodeList = new ArrayList<>();
        List<ListNode> revList = new ArrayList<>();

        ListNode slow = head, fast = head;
        int count = 1;
        while (fast != null) {
            if (count == K) {
                ListNode nextFast = fast.next;
                fast.next = null;
                nodeList.add(slow);

                slow = nextFast;
                fast = nextFast;
                count = 1;
                continue;
            }
            fast = fast.next;
            count++;
        }
        // for sure we know all the added nodes are of length K.
        for (ListNode currhead : nodeList) {
            ListNode reversedHead = reverse(currhead);
            revList.add(reversedHead);
        }
        revList.add(slow);

        for (int i = 1; i < revList.size(); i++) {
            nodeList.get(i - 1).next = revList.get(i);
        }

        ListNode finalHead = revList.get(0);

        ListNode.showNodes(finalHead);

    }
    
    /**
     * 
     *      1 => 2  => 3  =>  4
     *      
     *      2 => 1
     *      h
     * 
     * */


    private static void reverseKGroupOptimal(ListNode head, final int K) {
        ListNode headptr = head, tailPtr = head;
        ListNode globalHead = null, prevTail = null;
        int count = 1;
        while (tailPtr != null) {
            if (count == K) {
                ListNode nextNode = tailPtr.next;
                tailPtr.next = null;

                ListNode revHead = reverse(headptr);
                if (globalHead == null) globalHead = revHead;
                else prevTail.next = revHead;

                
                //reset all variables;
                prevTail = headptr;
                headptr = nextNode;
                tailPtr = nextNode;
                count = 1;
                continue;
            }
            tailPtr = tailPtr.next;
            count++;
        }
        
        if(prevTail != null)    prevTail.next = headptr;

        ListNode.showNodes(globalHead);
    }


    public static void main(String[] args) {
        reverseKGroupOptimal(ListNode.getOddLengthList(), 2);
    }
}
