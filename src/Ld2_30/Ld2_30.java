package Ld2_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

class Node {
    public int data;
    private Node next;

    Node(int number) {
        data = number;
    }

    public int getData() {
        return data;
    }

    /*public void setData(int data) {
        this.data = data;
    }*/

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {
    private Node head = null, tail = null;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size == 10;
    }

    public void insert(int current) {
        Node node, ptr, temp;
        node = new Node(current);
        boolean inserted = false;

        if (isEmpty()) {
            head = node;
            node.setNext(head);
            tail = head;
        } else if (current <= head.getData()) {
            node.setNext(head);
            tail.setNext(node);
            head = node;
        } else if (current >= tail.getData()) {
            tail.setNext(node);
            node.setNext(head);
            tail = node;
        } else {
            temp = head;
            ptr = head.getNext();

            while (temp != tail) {
                if (current >= temp.getData() &&
                        current <= ptr.getData()) {
                    temp.setNext(node);
                    node.setNext(ptr);
                    inserted = true;
                    break;
                } else {
                    temp = ptr;
                    ptr = ptr.getNext();
                }
            }
            if (!inserted) {
                temp.setNext(node);
            }
        }
        size++;
    }

    public void deleteNode(int nodeIndex) {
        if (!isEmpty()) {
            if (nodeIndex == 1 && size == 1) {
                head = null;
                tail = null;
                size = 0;
                return;
            }

            if (nodeIndex == 1) {
                head = head.getNext();
                tail.setNext(head);
                size--;
                return;
            }

            if (nodeIndex == size) {
                Node node = head;
                for (int i = 1; i < size - 1; i++) {
                    node = node.getNext();
                }
                node.setNext(head);
                tail = node;
                size--;
                return;
            }

            Node node = head;
            nodeIndex--;
            for (int i = 1; i < size - 1; i++) {
                if (i == nodeIndex) {
                    Node temp = node.getNext();
                    temp = temp.getNext();
                    node.setNext(temp);
                    break;
                }
                node = node.getNext();
            }
            size--;
        } else {
            System.out.println("Saraksts ir tukšs!");
        }
    }

    public void outputSortedList() {
        Node node = head;
        if (isEmpty()) {
            System.out.println("Saraksts ir tukšs!");
            return;
        }

        if (head.getNext() == head) {
            System.out.print(head.getData() +
                    "\t" + node.getNext());
            return;
        }

        System.out.print(head.getData() + "\t");
        node = head.getNext();

        while (node.getNext() != head) {
            System.out.print(node.getData() + "\t");
            node = node.getNext();
        }

        System.out.print(node.getData() + "\n");
    }


    public int equalsToZero() {
        Node node;
        int quantifier = 0;

        if (head.data == 0) {
            quantifier++;
        }

        for (node = head;
             node != tail;
             node = node.getNext()) {
            if (node.getNext().data == 0) {
                quantifier++;
            }
        }
        return quantifier;
    }
}

public class Ld2_30 {
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
        System.out.println("0: Slēgt sesiju");

        boolean listCreated = false; // Checks if any value was input
        boolean endSession = false; // checks whether user closed session
        int choiceAnswer; // Operation to be performed
        int elementToInput; // Element to be added to the list

        try {
            do {
                System.out.println();
                System.out.print("Izvēlēties izpildes numuru: ");
                choiceAnswer = Integer.parseInt(br.readLine());
                switch (choiceAnswer) {
                    case 1:
                        while (!list.isFull()) {

                            for (int i = 0; i < 10; i++) {
                                System.out.print("Ievadiet veselo skaitli: ");
                                elementToInput = Integer.parseInt(br.readLine());
                                list.insert(elementToInput);
                            }
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

                        list.deleteNode(deletableElementIndex);

                        if (list.isEmpty()) {
                            System.out.println("Saraksts ir tukšs...");
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

                        System.out.println("Elementu daudzums kas ir " +
                                "vienādi ar nulli: " +
                                list.equalsToZero());
                        break;
                    case 0:
                        endSession = true;
                        break;
                    default:
                        System.out.print("Ievādīta nepieņēmāma vērtība!");
                }

                System.out.println("\nIzveidots saraksts:");
                list.outputSortedList();
                if (list.isFull()) {
                    System.out.println("Saraksts ir pilns...");
                }
            } while (!endSession);
        } catch (InputMismatchException | IOException |
                NumberFormatException e) {
            System.out.println("Nepareizs datu formāts!");
        }
        System.out.println("Sesija slēgta...");
    }
}
