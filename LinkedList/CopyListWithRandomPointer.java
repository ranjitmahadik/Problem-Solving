package LinkedList;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next, random;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private static Node getNode() {
        Node root = new Node(7);
        root.next = new Node(13);
        root.next.next = new Node(11);
        root.next.next.next = new Node(10);
        root.next.next.next.next = new Node(1);

        root.next.random = root;    //  13
        root.next.next.random = root.next.next.next.next;   //11
        root.next.next.next.random = root.next.next;    //10
        root.next.next.next.next.random = root; // 1

        return root;
    }


    private static Node generateCopy(Node head) {
        if (head == null) return null;

        Node temp = head;

        while (temp != null) {
            Node currentNodeCopy = new Node(temp.val);
            currentNodeCopy.next = temp.next;
            temp.next = currentNodeCopy;
            temp = currentNodeCopy.next;
        }

        temp = head;
        while (temp != null && temp.next != null) {
            Node copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        Node copyList = new Node(-1);
        Node dummyList = copyList;

        temp = head;
        while (temp != null) {
            dummyList.next = temp.next;
            dummyList = dummyList.next;

            temp.next = dummyList.next;

            temp = temp.next;
        }


        return copyList.next;
    }

    private static void show(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node copiedNode = generateCopy(getNode());
        show(getNode());
        show(copiedNode);
    }


}
