package com.saltuk.lru.cache;

import java.util.Map;
import java.util.HashMap;

/*
* 146. LRU Cache
 * */
class LRUCache {
    private Map<Integer, Info> keyToInfo = new HashMap<>();
    private NodeList nodes = new NodeList();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        var info = keyToInfo.get(key);

        if (info == null) {
            return -1;
        }

        nodes.moveTop(info.node);

        return info.value;
    }

    public void put(int key, int value) {
        if (keyToInfo.containsKey(key)) {
            update(key, value);
        } else {
            add(key, value);
        }
    }

    private void update(int key, int value) {
        var info = keyToInfo.get(key);
        nodes.remove(info.node);
        var newNode = nodes.addNode(key);
        keyToInfo.put(key, new Info(value, newNode));
    }

    private void add(int key, int value) {
        if (keyToInfo.size() >= capacity) {
            var nodeToRemove = nodes.getTail();
            nodes.remove(nodeToRemove);
            var removedKey = nodeToRemove.getKey();
            keyToInfo.remove(removedKey);
        }
        var newNode = nodes.addNode(key);
        keyToInfo.put(key, new Info(value, newNode));
    }

    class NodeList {
        private Node head = null;
        private Node tail = null;

        public void moveTop(Node node) {
            var nodeNext = node.getNext();
            var nodePrev = node.getPrev();

            if (nodePrev == null) {
                return;
            }

            if (nodeNext == null) {
                tail = nodePrev;
            } else {
                nodeNext.setPrev(nodePrev);
            }

            nodePrev.setNext(nodeNext);

            node.setNext(head);
            node.setPrev(null);

            head.setPrev(node);
            head = node;
        }

        public void remove(Node node) {
            var nodeNext = node.getNext();
            var nodePrev = node.getPrev();

            if(nodePrev == null) {
                head = nodeNext;
            } else {
                nodePrev.setNext(nodeNext);
            }
            if (nodeNext == null) {
                tail = nodePrev;
            } else {
                nodeNext.setPrev(nodePrev);
            }
        }

        public Node addNode(int key) {
            var node = new Node(key, null, head);
            if (head != null) {
                head.setPrev(node);
            }
            if (tail == null) {
                tail = node;
            }
            head = node;
            return node;
        }

        public Node getTail() {
            return tail;
        }

    }

    record Info(int value, Node node){}

    class Node {
        private final int key;
        private Node prev;
        private Node next;

        public Node(int key, Node prev, Node next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public Node getPrev() {
            return prev;
        }

        public Node getNext() {
            return next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

/**
 * Your com.saltuk.lru.cache.LRUCache object will be instantiated and called as such:
 * com.saltuk.lru.cache.LRUCache obj = new com.saltuk.lru.cache.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */