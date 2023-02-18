package com.stoxalpha;

public class BinarySearchTree {

    static class Node {
        int key;
        String value;
        Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node min() {
            if (left == null) {
                return this;
            } else {
                return left.min();
            }
        }
    }

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public String find(int key) {
        Node node = find(this.root, key);
        return node == null ? null : node.value;
    }

    private Node find(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        } else if (key < node.key) {
            return find(node.left, key);
        } else if (key > node.key) {
            return find(node.right, key);
        }

        return null;
    }

    public void insert(int key, String value) {
        root = insertItem(root, key, value);
    }

    private Node insertItem(Node node, int key, String value) {
        Node newNode = new Node(key, value);
        if (node == null) {
            node = newNode;
            return node;
        }

        if (key < node.key) {
            node.left = insertItem(node.left, key, value);
        } else {
            node.right = insertItem(node.right, key, value);
        }

        return node;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public Node findMin(Node node) {
        return node.min();
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key){
            node.right = delete(node.right, key);
        } else {
            System.out.println("This is the node we want to delete: " + node);

            //Case 1: No child
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                //Case 2: One child
                node = node.right;
            } else if (node.right == null) {
                //Case 2: One child
                node = node.left;
            } else {
                //Case 3: Two children
                Node minRight = findMin(node.right);

                node.key = minRight.key;
                node.value = minRight.value;

                node.right = delete(node.right, node.key);
            }

        }

        return node;
    }

}
