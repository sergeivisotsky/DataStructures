package LinkedLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

interface ILinkedList {
    void insert(int element);

    void deleteNode(int nodeIndex);

    void display();

    int equalsToZero();

    boolean isEmpty();

    boolean isFull();

    int getSize();
}


class LinkedList implements ILinkedList {

    class Node {
        int data;
        Node next;

        Node(int number) {
            data = number;
        }
    }

    private Node head = null, tail = null;
    private int size = 0;

    private void insertAtStart(int current) {
        Node node = new Node(current);
        node.next = head;
        tail.next = node;
        head = node;
    }

    private void insertInTheMiddle(int current) {
        Node node, temp, ptr;
        node = new Node(current);
        temp = head;
        ptr = head.next;

        while (temp != tail) {
            if (current >= temp.data &&
                    current <= ptr.data) {
                temp.next = node;
                node.next = ptr;
                break;
            } else {
                temp = ptr;
                ptr = ptr.next;
            }
        }
    }

    private void insertAtTheEnd(int current) {
        Node node = new Node(current);
        tail.next = node;
        node.next = head;
        tail = node;
    }

    @Override
    public void insert(int current) {
        Node node = new Node(current);
        if (isEmpty()) {
            head = node;
            node.next = head;
            tail = head;
        } else if (current <= head.data) {
            insertAtStart(current);
        } else if (current >= tail.data) {
            insertAtTheEnd(current);
        } else {
            insertInTheMiddle(current);
        }
        size++;
    }

    @Override
    public void deleteNode(int nodeIndex) {
        if (nodeIndex == 1 && size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        if (nodeIndex == 1) {
            head = head.next;
            tail.next = head;
            size--;
            return;
        }

        if (nodeIndex == size) {
            Node node = head;
            for (int i = 1; i < size - 1; i++) {
                node = node.next;
            }
            node.next = head;
            tail = node;
            size--;
            return;
        }

        Node node = head;
        nodeIndex--;
        for (int i = 1; i < size - 1; i++) {
            if (i == nodeIndex) {
                Node temp = node.next;
                temp = temp.next;
                node.next = temp;
                break;
            }
            node = node.next;
        }
        size--;
    }

    @Override
    public void display() {
        Node node;
        if (isEmpty()) {
            System.out.println("Saraksts ir tukšs!");
            return;
        }

        if (head.next == head) {
            System.out.print(head.data);
            return;
        }

        System.out.print(head.data + "\t");
        node = head.next;

        while (node.next != head) {
            System.out.print(node.data + "\t");
            node = node.next;
        }

        System.out.print(node.data + "\n");
    }

    @Override
    public int equalsToZero() {
        Node node;
        int quantifier = 0;

        if (head.data == 0) {
            quantifier++;
        }

        for (node = head;
             node != tail;
             node = node.next) {
            if (node.next.data == 0) {
                quantifier++;
            }
        }
        return quantifier;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == 10;
    }
}

public class SortedSinglyLinkedCircularList {
    public static void main(String[] args) {
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
        System.out.println("Sergejs Visockis IRDBD12 171RDB043");

        // User menu to choose answer variant
        System.out.println("1: Izveidot sarakstu");
        System.out.println("2: Izmest no saraksta elementu ar konkrētu pozīciju");
        System.out.println("3: Elementu daudzums sarakstā");
        System.out.println("4: Elementu daudzums kas ir vienādi ar nulli");
        System.out.println("5: Tukšuma statuss");
        System.out.println("6: Pilnīguma statuss");
        System.out.println("0: Slēgt sesiju");

        boolean listCreated = false; // Checks if any value was input
        boolean endSession = false; // checks whether user closed session
        int choiceAnswer; // Operation to be performed
        int elementToInput; // Element to be added to the list

        try {
            do {
                System.out.println();
                System.out.print("Izvēlēties saskarnes numuru: ");
                choiceAnswer = Integer.parseInt(br.readLine());
                switch (choiceAnswer) {
                    case 1:
                        while (!list.isFull()) {
                            System.out.print("Ievadiet veselo skaitli: ");
                            elementToInput = Integer.parseInt(br.readLine());
                            list.insert(elementToInput);
                        }

                        if (list.isFull()) {
                            System.out.println("\nSaraksts ir pilns!" + "\n" +
                                    "Ievietot elementus vairs nav iespējams!");
                        }
                        System.out.println("\nIzveidots saraksts:");
                        list.display();

                        listCreated = true;
                        break;
                    case 2:
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }
                        if (!list.isEmpty()) {
                            System.out.print("Dzēšamais elements: ");
                            int deletableElementIndex =
                                    Integer.parseInt(br.readLine());

                            if (deletableElementIndex < 1 ||
                                    deletableElementIndex > list.getSize()) {
                                System.out.println("Nepareiza pozcijas vertība!");
                            } else {
                                list.deleteNode(deletableElementIndex);
                                System.out.println("\nIzveidots saraksts:");
                                list.display();
                            }
                        } else {
                            System.out.println("Saraksts ir tukšs!");
                            continue;
                        }
                        break;
                    case 3:
                        System.out.println("Elementu daudzums sarakstā: " + list.getSize());
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

                        if (!list.isEmpty()) {
                            System.out.println("Elementu daudzums kas ir " +
                                    "vienādi ar nulli: " +
                                    list.equalsToZero());
                        } else {
                            System.out.println("Saraksts ir tukšs!");
                            continue;
                        }
                        break;
                    case 5:
                        System.out.println("Tukšuma statuss = " + list.isEmpty());
                        break;
                    case 6:
                        if (!listCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }
                        if (list.isFull()) {
                            System.out.println("Saraksts ir pilns!");
                        } else {
                            System.out.println("Saraksts nav pilns!");
                        }
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
