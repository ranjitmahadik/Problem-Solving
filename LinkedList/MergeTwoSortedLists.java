package LinkedList;

public class MergeTwoSortedLists {
    private static void merge(ListNode root1, ListNode root2) {
        ListNode temp1 = root1;
        ListNode temp2 = root2;

        ListNode ans = new ListNode(-1);
        ListNode finalRootNode = ans;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                ans.next = temp1;
                temp1 = temp1.next;
                ans = ans.next;
            } else {
                ans.next = temp2;
                temp2 = temp2.next;
                ans = ans.next;
            }
        }

        if (temp1 != null) ans.next = temp1;
        if (temp2 != null) ans.next = temp2;

        ListNode.showNodes(finalRootNode.next);
    }

    public static void main(String[] args) {
        ListNode root1 = ListNode.getInstance();
        ListNode root2 = ListNode.getInstance1();
        ListNode.showNodes(root1);
        ListNode.showNodes(root2);

        merge(root1, root2);
    }

}
