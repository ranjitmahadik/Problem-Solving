package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class RandomNode {
    static class RandomSampling {
        private List<ListNode> nodeList = new ArrayList<>();

        RandomSampling(ListNode head) {
            while (head != null) {
                ListNode currNode = head;
                head = head.next;
                currNode.next = null;
                nodeList.add(currNode);
            }
        }

        private int getRandom() {
            int nodeIdx = (int) (Math.random() * nodeList.size());
            return nodeList.get(nodeIdx).val;
        }
    }

    static class ReservoirSampling {
        private ListNode head;

        ReservoirSampling(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            int scope = 1, chosenValue = 0;
            ListNode temp = head;
            while (temp != null) {
                if (Math.random() < 1.0 / scope) {
                    chosenValue = temp.val;
                }
                scope += 1;
                temp = temp.next;
            }
            return chosenValue;
        }
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.getList();
        RandomSampling root = new RandomSampling(listNode);
        for (int i = 0; i < 6; i++) {
            System.out.print(" " + root.getRandom());
        }

        System.out.println();

        ReservoirSampling rev = new ReservoirSampling(listNode);
        for (int i = 0; i < 6; i++) {
            System.out.print(" " + rev.getRandom());
        }
    }
}
