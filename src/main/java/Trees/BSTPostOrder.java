package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IBinarySearchTree {
    void insert(int element);

    void postOrderOutput();

    int countNodesWithTwoChildren();

    int evenElementQuantity();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}

class BinarySearchTree implements IBinarySearchTree {
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

    BinarySearchTree(int maxSize) {
        this.maxSize = maxSize;
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
    public void postOrderOutput() {
        postOrderWrapper(root);
    }

    private void postOrderWrapper(Node root) {
        if (root != null) {
            if (isEmpty()) {
                throw new IllegalStateException("Koks ir tukšs!");
            }

            postOrderWrapper(root.left);
            postOrderWrapper(root.right);
            System.out.print(root.data + "\t");

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
}

public class BSTPostOrder {
    private static boolean treeCreated = false;

    public static void main(String[] args) {
        int answer;
        String yesNoAnswer;
        int element;

        try (BufferedReader input =
                     new BufferedReader(
                             new InputStreamReader(System.in))) {
            int treeSize;
            System.out.println("Sergejs Visockis IRDBD12 171RDB043");
            System.out.print("Koka garums (max 15): ");
            treeSize = Integer.parseInt(input.readLine());
            if (treeSize > 15) {
                throw new IllegalStateException("Koka garums nevar " +
                        "saturēt vairāk nekā 15 elementu!");
            }
            BinarySearchTree tree = new BinarySearchTree(treeSize);

            do {
                System.out.println("1: Pievenot elementu");
                System.out.println("2: Parādīt koku (Postorderālais apgaits)");
                System.out.println("3: Atrast cik kokā ir virsotņu ar diviem bērniem");
                System.out.println("4: Saskaitīt cik kokā ir pāra elementu");
                System.out.print("\nIzvēlēties saskarnes vērtību: ");
                answer = Integer.parseInt(input.readLine());
                switch (answer) {
                    case 1:
                        if (!tree.isFull()) {
                            System.out.print("Pievienot elementu: ");
                            element = Integer.parseInt(input.readLine());
                            tree.insert(element);
                        } else {
                            System.out.println("Koks ir pilns!");
                        }
                        treeCreated = true;
                        break;
                    case 2:
                        treeIsNotCreated();
                        tree.postOrderOutput();
                        break;
                    case 3:
                        treeIsNotCreated();
                        System.out.println(
                                tree.countNodesWithTwoChildren());
                        break;
                    case 4:
                        treeIsNotCreated();
                        System.out.println(
                                tree.evenElementQuantity());
                        break;
                    default:
                        throw new IllegalStateException("Ievadīta nepieņēmama vērtība!");
                }
                System.out.print("\nTurpināt? (y/n) ");
                yesNoAnswer = input.readLine();
            } while (yesNoAnswer.equals("y") || yesNoAnswer.equals("Y"));
        } catch (IOException | NumberFormatException e) {
            System.out.println("Nepareizs datu formāts!");
        }
    }

    private static void treeIsNotCreated() {
        if (!treeCreated) {
            System.out.println("Citas funkcijas nav pieejamas " +
                    "kāmēr koks nav izveidots!");
        }
    }
}
