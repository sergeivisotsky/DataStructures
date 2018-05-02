package Ld4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IBinarySearchTreeTwo {
    void insert(int element);

    void inOrderOutput();

    int countNodesWithRightChildren();

    int negativeElementQuantity();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}

class BSTInOrder implements IBinarySearchTreeTwo {
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

    BSTInOrder(int maxSize) {
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
    public void inOrderOutput() {
        inOrderOutputWrapper(root);
    }

    private void inOrderOutputWrapper(Node root) {
        if (root != null) {
            emptyStatusChecker();
            inOrderOutputWrapper(root.left);
            System.out.print(root.data + "\t");
            inOrderOutputWrapper(root.right);
        }
    }

    @Override
    public int countNodesWithRightChildren() {
        emptyStatusChecker();
        return countNodesWithRightChildrenWrapper(root);
    }

    private int countNodesWithRightChildrenWrapper(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right != null) {
            return 1 + countNodesWithRightChildrenWrapper(root.right);
        }

        return countNodesWithRightChildrenWrapper(root.left) +
                countNodesWithRightChildrenWrapper(root.right);
    }

    public int countNodesWithoutChildren() {
        emptyStatusChecker();
        return coundNodesWithoutChildrenWrapper(root);
    }

    private int coundNodesWithoutChildrenWrapper(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return coundNodesWithoutChildrenWrapper(root.left) +
                coundNodesWithoutChildrenWrapper(root.right);
    }

    @Override
    public int negativeElementQuantity() {
        emptyStatusChecker();
        return negativeElementQuantityWrapper(root);
    }

    private int negativeElementQuantityWrapper(Node root) {
        if (root == null) {
            return 0;
        }

        int value = negativeElementQuantityWrapper(root.left) +
                negativeElementQuantityWrapper(root.right);

        if (root.data < 0) {
            return value + 1;
        } else {
            return value;
        }
    }

    private void emptyStatusChecker() {
        if (isEmpty()) {
            throw new IllegalStateException("Tree is empty!");
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

public class Ld4_26 {
    private static boolean treeCreated = false;

    public static void main(String[] args) {
        int answer;
        String yesNoAnswer;
        int element;

        try (BufferedReader input =
                     new BufferedReader(
                             new InputStreamReader(System.in))) {
            int treeSize;
            System.out.println("BST inorder traversal");
            System.out.print("Tree size (max 15): ");
            treeSize = Integer.parseInt(input.readLine());
            if (treeSize > 15) {
                throw new IllegalStateException("Tree size shouldn't be greater than 15!");
            }
            BSTInOrder tree = new BSTInOrder(treeSize);

            do {
                System.out.println("1: insert");
                System.out.println("2: Inorder output");
                System.out.println("3: Nodes with one right children");
                System.out.println("4: Nodes without children");
                System.out.println("5: Negative element quantity");
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
                        tree.inOrderOutput();
                        break;
                    case 3:
                        treeIsNotCreated();
                        System.out.println(
                                tree.countNodesWithRightChildren());
                        break;
                    case 4:
                        treeIsNotCreated();
                        System.out.println(tree.countNodesWithoutChildren());
                        break;
                    case 5:
                        treeIsNotCreated();
                        System.out.println(
                                tree.negativeElementQuantity());
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
