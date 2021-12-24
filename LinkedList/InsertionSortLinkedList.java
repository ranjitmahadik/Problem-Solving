package LinkedList;


public class InsertionSortLinkedList {
    private static void insertionSortOnArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i + 1 < n) {
            int j = i + 1;                                      // 5    6   7   1
            while (j - 1 >= 0 && arr[j - 1] > arr[j]) {
                int key = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = key;
                j--;
            }
            i++;
        }

        for (int k : arr) System.out.print(k + " ");
    }


    private static ListNode sortedRoot = null;

    private static void sortLinkedListUsingInsertionSort(ListNode root) {
        ListNode currNode = root;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = null;
            insertProperly(currNode);
            currNode = nextNode;
        }

        System.out.println(sortedRoot);
    }

    //      *
    //  1   5   6   7   | 2
    private static void insertProperly(ListNode nextNode) {
        if (sortedRoot == null || nextNode.val <= sortedRoot.val) {
            nextNode.next = sortedRoot;
            sortedRoot = nextNode;
        } else {
            ListNode temp = sortedRoot;
            while (temp.next != null && temp.next.val < nextNode.val) temp = temp.next;
            nextNode.next = temp.next;
            temp.next = nextNode;
        }
    }


    private static void sortList(ListNode head) {
        ListNode dummy = new ListNode(-5555);
        dummy.next = head;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            if (nextNode != null && curr.val > nextNode.val) {
                curr.next = nextNode.next;                                      // 5 => 9
                nextNode.next = null;                                           //  2

                insertNodeCorrectly(dummy, nextNode);
                continue;
            }
            curr = curr.next;
        }
        System.out.println(dummy);
    }

    /***
     *              7
     *              -555 5   8   7
     *
     * */
    private static void insertNodeCorrectly(ListNode headPtr, ListNode unsortedNode) {
        ListNode dummyNode = headPtr;
        if (dummyNode.next.val >= unsortedNode.val) {
            unsortedNode.next = dummyNode.next;
            dummyNode.next = unsortedNode;
            return;
        }
        while (dummyNode.next != null && dummyNode.next.val < unsortedNode.val) dummyNode = dummyNode.next;
        unsortedNode.next = dummyNode.next;
        dummyNode.next = unsortedNode;
    }


    public static void main(String[] args) {
        insertionSortOnArray(new int[]{4, 1, 3, 9, 7});
//        sortLinkedListUsingInsertionSort(ListNode.getUnsortedList());
        sortList(ListNode.getUnsortedList());
    }
}
