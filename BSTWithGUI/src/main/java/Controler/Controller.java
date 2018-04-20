package Controler;

import View.Fields;

public class Controller implements IBinarySearchTree {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;
    private int maxSize;

    public Controller(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void insert(int element) {
        root = insertWrapper(root, element);
        size++;
    }

    private Node insertWrapper(Node node, int element) {
        if (node == null) {
            return new Node(element);
        }

        Node newSubtree;
        if (element < node.data) {
            newSubtree = insertWrapper(node.left, element);
            node.left = newSubtree;
            return node;
        } else if (element > node.data) {
            newSubtree = insertWrapper(node.right, element);
            node.right = newSubtree;
            return node;
        }
        return node;
    }

    @Override
    public void postorderOutput() {
        postorderWrapper(root);
    }

    private void postorderWrapper(Node root) {
        if (root != null) {
            if (isEmpty()) {
                throw new IllegalStateException("Koks ir tukšs!");
            }

            postorderWrapper(root.left);
            postorderWrapper(root.right);
//            System.out.print(root.data + "\t");
            Fields.textPane.setText(Integer.toString(root.data));

        }
    }

    @Override
    public int countNodesWithTwoChildren() {
        return countNodesWithTwoChildrenWrapper(root);
    }

    private int countNodesWithTwoChildrenWrapper(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left != null && root.right != null) {
            return 1 + countNodesWithTwoChildrenWrapper(root.left) +
                    countNodesWithTwoChildrenWrapper(root.right);
        }

        return countNodesWithTwoChildrenWrapper(root.left) +
                countNodesWithTwoChildrenWrapper(root.right);
    }

    @Override
    public int evenElementQuantity() {
        return evenElementQuantityWrapper(root);
    }

    private int evenElementQuantityWrapper(Node root) {
        if (root == null) {
            return 0;
        }

        int value = evenElementQuantityWrapper(root.left) +
                evenElementQuantityWrapper(root.right);

        if (root.data % 2 == 0) {
            return value + 1;
        } else {
            return value;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }
}
