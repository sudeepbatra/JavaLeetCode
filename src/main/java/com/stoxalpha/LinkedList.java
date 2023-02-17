package com.stoxalpha;

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

            return count;
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
}