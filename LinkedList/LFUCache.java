package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    static class Node {
        int key, value, occurrence;
        Node prev, next;

        public Node(int key, int value, int occurrence) {
            this.key = key;
            this.value = value;
            this.occurrence = occurrence;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", occurrence=" + occurrence +
                    '}';
        }
    }

    private int capacity;
    private Map<Integer, Node> lookup = new HashMap<>();
    private Node headPtr, tailPtr;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.headPtr = new Node(-1, -1, -1);
        this.tailPtr = new Node(-1, -1, -1);

        this.tailPtr.next = this.headPtr;
        this.headPtr.prev = this.tailPtr;
    }

    public int get(int key) {
        if (lookup.containsKey(key)) {
            Node node = lookup.get(key);
            removeNode(key);
            addToFront(key, node.value, node.occurrence + 1);
            return lookup.get(key).value;
        }
        return -1;
    }

    private boolean checkCapacity() {
        return this.lookup.size() < this.capacity;
    }

    public void put(int key, int value) {
        if (lookup.containsKey(key)) {
            int occurrence = lookup.get(key).occurrence;
            removeNode(key);
            addToFront(key, value, occurrence + 1);
        } else if (this.checkCapacity()) {
            addToFront(key, value);
        } else {
            removeLast();
            addToFront(key, value);
        }
    }

    private void removeLast() {
        removeNode(this.tailPtr.next.key);
    }

    private void addToFront(int key, int value) {
        addToFront(key, value, 1);
    }

    private void addToFront(int key, int value, int occurrence) {
        Node newNode = new Node(key, value, occurrence);

        Node prevNode = this.headPtr.prev;

        newNode.prev = prevNode;
        newNode.next = this.headPtr;

        prevNode.next = newNode;
        this.headPtr.prev = newNode;
        lookup.put(key, newNode);
    }

    private void removeNode(int key) {
        Node nodeToBeRemoved = lookup.get(key);
        Node prevNode = nodeToBeRemoved.prev;
        Node nextNode = nodeToBeRemoved.next;

        if (prevNode != null) prevNode.next = nextNode;
        if (nextNode != null) nextNode.prev = prevNode;

        nodeToBeRemoved.next = null;
        nodeToBeRemoved.prev = null;
        lookup.remove(nodeToBeRemoved.key);
    }

    @Override
    public String toString() {
        return "LFUCache{" +
                "lookup=" + lookup +
                '}';
    }

    public static void main(String[] args) {
    }

}
