import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;


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

    private static void deleteNodeElement(int nodeIndex) {
        if (!empty()) {

            Node<Integer> current = head;
            Node<Integer> previous = null;
//              1: Empty list: noshing change
//              2: One element: put parent = null
//              3: Many elements:
//                 a: Deletable element first
//                 b: Deletable element in the middle or in the end
            while (current != null) {
                if (current.data.equals(nodeIndex)) {

                    // Node in the middle or in the end
                    if (previous != null) {
                        // Bullet 3b

                        // Before:  Head -> 3 -> 5 -> null
                        // After:   Head -> 3 ------> null

                        previous.next = current.next;

                        if (current.next == null) {
                            tail = previous;
                        } // git test
                    } else {
                        head = head.next;

                        if (head == null) {
                            tail = null;
                        }
                    }
                    size--;
                }

                previous = current;
                current = current.next;
            }

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
                                insert(Integer.parseInt(br.readLine()));
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
                        deleteNodeElement(deletableElementIndex);

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
