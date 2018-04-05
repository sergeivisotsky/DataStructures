package Ld4_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IBinarySearchTree {
    void insert(int element);

    void outputVertexes();

    void findTwoChildes();

    void evenElementQuantity();

    int getSize();

    boolean isEmpty();
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinarySearchTree implements IBinarySearchTree {
    private Node root = null;
    private Node parent = null;
    private int size = 0;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(int element) {
        /*Node node = new Node(element);
        if (node.root == null) {
            node.root = new Node(element);
        }*/
    }

    @Override
    public void outputVertexes() {

    }

    @Override
    public void findTwoChildes() {

    }

    @Override
    public void evenElementQuantity() {

    }
}

public class Ld4_30 {
    private static boolean treeCreated = false;

    public static void main(String[] args) {
        BufferedReader input =
                new BufferedReader(
                        new InputStreamReader(System.in));
        BinarySearchTree tree = new BinarySearchTree();
        int answer;
        String yesNoAnswer;
        int element;

        try {
            do {
                System.out.println("1: Aizpildīt koku");
                System.out.println("2: Parādīt koku");
                System.out.println("3: Atrast cik kokā ir virsotņu ar diviem bērniem");
                System.out.println("4: Saskaitīt cik kokā ir pāra elementu");
                System.out.print("\nIzvēlēties saskarnes vērtību: ");
                answer = Integer.parseInt(input.readLine());
                switch (answer) {
                    case 1:
                        System.out.print("Pievienot elementu: ");
                        element = Integer.parseInt(input.readLine());
                        tree.insert(element);
                        treeCreated = true;
                        break;
                    case 2:
                        treeIsNotCreated();
                        break;
                    case 3:
                        treeIsNotCreated();
                        break;
                    case 4:
                        treeIsNotCreated();
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

    public static void treeIsNotCreated() {
        if (!treeCreated) {
            System.out.println("Koks pagaidam nav izveidots!");
        }
    }
}
