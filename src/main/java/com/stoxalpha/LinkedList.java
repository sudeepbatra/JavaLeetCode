package com.stoxalpha;

import java.util.HashSet;

public class LinkedList {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    //More elegant/efficient way of keeping count of elements.
    private int size;

    public void addFront(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public int getFirst() {
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }

        return head.data;
    }

    public int getLast() {
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    public void addLast(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current.next = null;
            }

            current.next = node;
        }
    }

    public int size() {
        //Brute force way of keeping the size.
        if (head == null) {
            return 0;
        } else {
            Node current = head;
            int count = 1;
            while (current.next != null) {
                current = current.next;
                count++;
            }

            return ++count;
        }
    }

    public void clear() {
        head = null;
        this.size = 0;
    }

    //O(n)
    public void delete(int value) {
        if (head == null) {
            throw new IllegalStateException("Empty list");
        }

        if (head.data == value) {
            head = head.next;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    public void removeDuplicates() {
        removeDuplicates(this.head);
    }

    private void removeDuplicates(Node current) {
        HashSet<Integer> uniques = new HashSet<>();
        Node previous = null;

        while (current != null) {
            if (uniques.contains(current.data)) {
                previous.next = current.next;
            } else {
                uniques.add(current.data);
                previous = current;
            }

            current = current.next;
        }
    }

    public boolean hasLoop() {
        return hasLoop(this.head);
    }

    private boolean hasLoop(Node first) {
        Node slow = first;
        Node fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next; //1 hop
            fast = fast.next.next; //2 hop

            if (slow == fast) { //fast caught up to slow, so there is a loop.
                return true;
            }
        }

        return false;
    }
}