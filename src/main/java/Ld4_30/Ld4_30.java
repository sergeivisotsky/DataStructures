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

    boolean isFull();
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
    private Node root;
    private Node parent;
    private int size;
    private int maxSize;

    BinarySearchTree(int maxSize) {
        this.maxSize = maxSize;
        root = null;
        parent = null;
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
        Node node = new Node(element);
        /*if (node.root == null) {
            node.root = new Node(element);
        }*/
        if (!isFull()) {
            node = root;
        }
        size++;
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

        int answer;
        String yesNoAnswer;
        int element;

        try {
            int treeSize;
            System.out.println("Sergejs Visockis IRDBD12 171RDB043");
            System.out.print("Koka garums (max 15): ");
            treeSize = Integer.parseInt(input.readLine());
            if (treeSize > 15) {
                throw new IllegalStateException("Koka garums nevar saturēt vairāk nekā 15 elementu!");
            }
            BinarySearchTree tree = new BinarySearchTree(treeSize);

            do {
                System.out.println("1: Pievenot elementu");
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
