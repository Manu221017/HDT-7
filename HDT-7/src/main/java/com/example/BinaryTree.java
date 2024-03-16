package com.example;

public class BinaryTree<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private BinaryTree<K, V> left;
    private BinaryTree<K, V> right;

    public BinaryTree(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void insert(K key, V value) {
        if (key.compareTo(this.key) < 0) {
            if (left == null) {
                left = new BinaryTree<>(key, value);
            } else {
                left.insert(key, value);
            }
        } else if (key.compareTo(this.key) > 0) {
            if (right == null) {
                right = new BinaryTree<>(key, value);
            } else {
                right.insert(key, value);
            }
        }
    }

    public V search(K key) {
        if (key.equals(this.key)) {
            return this.value;
        } else if (key.compareTo(this.key) < 0 && left != null) {
            return left.search(key);
        } else if (key.compareTo(this.key) > 0 && right != null) {
            return right.search(key);
        } else {
            return null;
        }
    }

    public void inorderTraversal() {
        if (left != null) {
            left.inorderTraversal();
        }
        System.out.println("(" + key + ", " + value + ")");
        if (right != null) {
            right.inorderTraversal();
        }
    }
}

