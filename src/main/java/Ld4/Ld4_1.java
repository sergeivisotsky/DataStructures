package Ld4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IBinarySearchTreeThree {
    void insert(int element);

    void preOrderOutput();

    int countNodesWithoutChildren();

    int intervalNumberQuantity();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}

class BSTPreOrder implements IBinarySearchTreeThree {
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

    BSTPreOrder(int maxSize) {
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
    public void preOrderOutput() {
        preOrderOutputWrapper(root);
    }

    private void preOrderOutputWrapper(Node root) {
        if (root != null) {
            if (isEmpty()) {
                throw new IllegalStateException("Tree is empty!");
            }

            System.out.print(root.data + "\t");
            preOrderOutputWrapper(root.left);
            preOrderOutputWrapper(root.right);
        }
    }

    @Override
    public int countNodesWithoutChildren() {
        return countNodesWithoutChildrenWrapper(root);
    }

    private int countNodesWithoutChildrenWrapper(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null || root.right == null) {
            return 1 + countNodesWithoutChildrenWrapper(root.left) +
                    countNodesWithoutChildrenWrapper(root.right);
        }

        return countNodesWithoutChildrenWrapper(root.left) +
                countNodesWithoutChildrenWrapper(root.right);
    }

    @Override
    public int intervalNumberQuantity() {
        return intervalNumberQuantityWrapper(root);
    }

    private int intervalNumberQuantityWrapper(Node root) {
        if (root == null) {
            return 0;
        }

        int value = intervalNumberQuantityWrapper(root.left) +
                intervalNumberQuantityWrapper(root.right);

        if (root.data >= -10 && root.data <= 10) {
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

public class Ld4_1 {
    private static boolean treeCreated = false;

    public static void main(String[] args) {
        int answer;
        String yesNoAnswer;
        int element;

        try (BufferedReader input =
                     new BufferedReader(
                             new InputStreamReader(System.in))) {
            int treeSize;
            System.out.println("BST preorder traversal");
            System.out.print("Tree size (max 15): ");
            treeSize = Integer.parseInt(input.readLine());
            if (treeSize > 15) {
                throw new IllegalStateException("Tree size shouldn't be greater than 15!");
            }
            BSTPreOrder tree = new BSTPreOrder(treeSize);

            do {
                System.out.println("1: insert");
                System.out.println("2: Preorder output");
                System.out.println("3: Nodes without children");
                System.out.println("4: Interval numbers");
                System.out.print("\nAnswer: ");
                answer = Integer.parseInt(input.readLine());
                switch (answer) {
                    case 1:
                        if (!tree.isFull()) {
                            System.out.print("Add element: ");
                            element = Integer.parseInt(input.readLine());
                            tree.insert(element);
                        } else {
                            System.out.println("Tree is full!");
                        }
                        treeCreated = true;
                        break;
                    case 2:
                        treeIsNotCreated();
                        tree.preOrderOutput();
                        break;
                    case 3:
                        treeIsNotCreated();
                        System.out.println(
                                tree.countNodesWithoutChildren());
                        break;
                    case 4:
                        treeIsNotCreated();
                        System.out.println(
                                tree.intervalNumberQuantity());
                        break;
                    default:
                        throw new IllegalStateException("Illegal value!");
                }
                System.out.print("\nContinue? (y/n) ");
                yesNoAnswer = input.readLine();
            } while (yesNoAnswer.equals("y") || yesNoAnswer.equals("Y"));
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid data format!");
        }
    }

    private static void treeIsNotCreated() {
        if (!treeCreated) {
            System.out.println("Tree is not created!");
        }
    }
}
