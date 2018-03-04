import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;


public class Ld2_30 {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        Node(E num) {
            this.data = num;
        }
    }

    private static BufferedReader br =
            new BufferedReader(
                    new InputStreamReader(System.in));
    private static Node<Integer> head = null;
    private static Node<Integer> tail = null;
    private static int size = 0;

    @Contract(pure = true)
    private static boolean empty() {
        return size == 0;
    }

    private static void insert(int current) {
        Node<Integer> node = new Node<>(current);
        node.next = tail;
        if (tail == null) {
            tail = node;
        } else {
            head.next = node;
        }

        head = node;
        size++;
    }

    private static void outputSortedList() {
        Node<Integer> temp = tail;
        for (int i = 0; i < size; i++) {
            if (temp != null) {
                System.out.print(temp.data + "\t");
                temp = temp.next;
            }
        }
        System.out.println();
    }


    @Contract(pure = true)
    private static boolean full() {
        return size == 10;
    }

    @Contract(pure = true)
    private static int size() {
        return size;
    }

    @Contract(pure = true)
    private static int equalsToZero() {
        Node<Integer> node = tail;
        int quantifier = 0;
        for (int i = 0; i < size; i++) {
            if (node.data == 0) {
                quantifier++;
            }
        }
        return quantifier;
    }

    private static void deleteNode(int nodeIndex) {
        if (!empty()) {
            if (head == null) {
                return;
            }

            Node<Integer> node = head;

            for (int i = 0; i < nodeIndex; i++) {
                node = node.next;
            }

            node.next = node;
            size--;

            outputSortedList();
        } else {
            System.out.println("Saraksts ir tukšs!");

        }
    }

    public static void main(String[] args) {
        System.out.println("Sergejs Visockis IRDBD12 171RDB043");

        // User menu to choose answer variant
        System.out.println("1: Izveidot sarakstu");
        System.out.println("2: Izmest no saraksta elementu ar konkrētu pozīciju");
        System.out.println("3: Elementu daudzums sarakstā");
        System.out.println("4: Elementu daudzums kas ir vienādi ar nulli");
        System.out.println("5 (Test): Paņēmt elelemntu ar konkrētu pozīciju");
        System.out.println("0: Slēgt sesiju");

        boolean listCreated = false; // Checks if any value was input
        boolean endSession = false; // checks whether user closed session

        int choiceAnswer;
        int elementToInput;

        try {
            do {
                System.out.println();
                System.out.print("Izvēlēties saskarsmes vērtību: ");
                choiceAnswer = Integer.parseInt(br.readLine());
                switch (choiceAnswer) {
                    case 1:
                        while (!full()) {

                            for (int i = 0; i < 10; i++) {
                                System.out.print("Ievadiet " + (i + 1) + " elementu: ");
                                elementToInput = Integer.parseInt(br.readLine());
                                insert(elementToInput);
                            }
                            System.out.println("\nIzveidots saraksts:");
                            outputSortedList();
                        }

                        if (full()) {
                            System.out.println("Saraksts ir pilns...");
                        }
                        listCreated = true;
                        break;
                    case 2:
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }
                        System.out.print("Dzēšamais elements: ");
                        int deletableElementIndex =
                                Integer.parseInt(br.readLine());

                        deleteNode(deletableElementIndex);

                        if (empty()) {
                            System.out.println("Saraksts ir tukšs...");
                        }
                        break;
                    case 3:
                        System.out.println(size());
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }
                        break;
                    case 4:
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }

                        System.out.println(equalsToZero());
                        break;
                    case 5:
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }

                        System.out.print("Elementa indekss: ");
                        int nodeIndex = Integer.parseInt(br.readLine());
//                        System.out.print(getNodeAt(nodeIndex));
                        break;
                    case 0:
                        endSession = true;
                        break;
                    default:
                        System.out.print("Ievādīta nepieņēmāma vērtība!");
                }
            } while (!endSession);
        } catch (InputMismatchException | IOException |
                NumberFormatException e) {
            System.out.println("Nepareizs datu formāts!");
        }
        System.out.println("Sesija slēgta...");
    }
}
