package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class Node {
        int val, key;
        Node prev, next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    private Map<Integer, Node> lookup = new HashMap<>();
    private int capacity;
    private Node tailPtr, headPtr;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.tailPtr = new Node(-1, -1);
        this.headPtr = new Node(-1, -1);

        this.headPtr.prev = this.tailPtr;
        this.tailPtr.next = this.headPtr;
    }

    private void addToFront(int key, int val) {
        Node newNode = new Node(key, val);

        Node prevNodeHead = this.headPtr.prev;
        prevNodeHead.next = newNode;
        newNode.prev = prevNodeHead;
        newNode.next = this.headPtr;
        this.headPtr.prev = newNode;
        lookup.put(key, newNode);
    }

    public void put(int key, int val) {
        if (lookup.containsKey(key)) {
            removeNode(key);
            addToFront(key, val);
        } else if (this.checkCapacity()) {
            addToFront(key, val);
        } else {
            this.removeLast();
            addToFront(key, val);
        }
    }

    private void removeLast() {
        removeNode(this.tailPtr.next.key);
    }

    private void removeNode(int key) {
        Node nodeToDeleted = lookup.get(key);
        Node prevNode = nodeToDeleted.prev;
        Node nextNode = nodeToDeleted.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        nodeToDeleted.prev = null;
        nodeToDeleted.next = null;
        lookup.remove(nodeToDeleted.key);
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "lookup=" + lookup +
                '}';
    }

    private boolean checkCapacity() {
        return this.lookup.size() < this.capacity;
    }

    public void printHeadTail() {
        System.out.println("head : " + this.headPtr.prev);
        System.out.println("tail : " + this.tailPtr.next);
    }

    public int get(int key) {
        if (lookup.containsKey(key)) {
            Node node = lookup.get(key);
            removeNode(key);
            addToFront(key, node.val);
            return lookup.get(key).val;
        }
        return -1;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        System.out.println(lruCache);
        lruCache.put(2, 2);
        System.out.println(lruCache);
        lruCache.printHeadTail();
        lruCache.put(1, 3);
        System.out.println(lruCache);
        lruCache.get(2);
        System.out.println(lruCache);
        lruCache.printHeadTail();
        lruCache.put(10, 3);
        System.out.println(lruCache);
        lruCache.printHeadTail();

    }

}

