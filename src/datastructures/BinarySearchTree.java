package datastructures;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void insert(T value) {
        if (root == null) {
            root = new Node(value);
            size += 1;
        } else {
            Node currentNode = root;

            while (true) {
                int comparison = value.compareTo(currentNode.data);

                if (comparison < 0) {
                    if (currentNode.left == null) {
                        currentNode.left = new Node(value);
                        size += 1;
                        return;
                    }

                    currentNode = currentNode.left;
                } else if (comparison > 0) {
                    if (currentNode.right == null) {
                        currentNode.right = new Node(value);
                        size += 1;
                        return;
                    }

                    currentNode = currentNode.right;
                } else {
                    return;
                }
            }
        }
    }

    public boolean search(T value) {
        if (root == null) {
            return false;
        }

        Node currentNode = root;

        while (true) {
            int comparison = value.compareTo(currentNode.data);

            if (comparison < 0) {
                if (currentNode.left == null) {
                    return false;
                }

                currentNode = currentNode.left;
            } else if (comparison > 0) {
                if (currentNode.right == null) {
                    return false;
                }

                currentNode = currentNode.right;
            } else {
                return true;
            }
        }
    }

    public T findMin() {
        if (root == null) {
            return null;
        }

        Node currentNode = root;

        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.data;
    }

    public T findMax() {
        if (root == null) {
            return null;
        }

        Node currentNode = root;

        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode.data;
    }

    public void remove(T value) {
        root = removeRecursion(root, value);
    }

    private Node removeRecursion(Node node, T value) {
        if (node == null) return null;

        int comparison = value.compareTo(node.data);

        if (comparison < 0) {
            node.left = removeRecursion(node.left, value);
        } else if (comparison > 0) {
            node.right = removeRecursion(node.right, value);
        } else {
            if (node.right == null && node.left == null) {
                size -= 1;
                return null;
            }
            else if (node.right != null && node.left == null){
                size -= 1;
                return node.right;
            }
            else if (node.right == null) {
                size -= 1;
                return node.left;
            } else {
                T successor = findMin(node.right);
                node.data = successor;
                node.right = removeRecursion(node.right, successor);
            }
        }

        return node;
    }

    private T findMin(Node node) {
        if (node == null) {
            return null;
        }

        Node currentNode = node;

        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.data;
    }

    public List<T> inOrder() {
        List <T> result = new ArrayList<>();
        collectData(root, result);
        return result;
    }

    private void collectData(Node currentNode, List<T> resultList) {
        if (currentNode == null) return;

        collectData(currentNode.left, resultList);
        resultList.add(currentNode.data);
        collectData(currentNode.right, resultList);
    }

    public int height() {
        return heightRecursion(root);
    }

    private int heightRecursion(Node currentNode) {
        if (currentNode == null) return -1;

        int left = heightRecursion(currentNode.left);
        int right = heightRecursion(currentNode.right);
        return 1 + Math.max(left, right);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }
}
