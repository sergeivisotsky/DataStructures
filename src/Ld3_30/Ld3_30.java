package Ld3_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
    /*    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }*/
}

class VectorQueue {
    private Node head = null, tail = null;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return size == 10;
    }

    public void enQueue(int element) {
        Node node = new Node(element);
        if (!isFull()) {
            tail = node;
        }
        size++;
    }

    public void outputQueue() {
        Node node = tail;
        if (isEmpty()) {
            System.out.println("Rinda ir tukša!");
            return;
        }

        if (tail.next == head) {
            System.out.print(head.next +
                    "\t" + node.next);
            return;
        }

        System.out.print(head.next + "\t");
        node = head.next;

        while (node.next != head) {
            System.out.println(node.data + "\t");
            node = node.next;
        }

        System.out.print(node.data + "\t");
    }

    public void deQueue() {

    }



    public Integer peek() {
        final Node head = this.head;
        return (head == null) ?
                null : head.data;
    }
}

public class Ld3_30 {
    private static VectorQueue queue = new VectorQueue();

    public static void main(String[] args) {
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        System.out.println("Sergejs Visockis IRDBD12 171RDB043");

        // User menu to choose answer variant
        System.out.println("1: Pievienot elementu rindā");
        System.out.println("2: Izmest elementu no rindas");
        System.out.println("3: Elementu daudzums rindā");
        System.out.println("4: Radīt pirmo elementu");
        System.out.println("5: Tukšuma statuss");
        System.out.println("6: Pilnīguma statuss");
        System.out.println("7: Negatīvu elementu daudzums");
        System.out.println("0: Slēgt sesiju");

        boolean queueCreated = false; // Checks if any value was input
        boolean endSession = false; // checks whether user closed session
        int choiceAnswer; // Operation to be performed
        int elementToBeAdded; // Element to be added to the list

        try {
            do {
                System.out.println();
                System.out.print("Izvēlēties saskarnes numuru: ");
                choiceAnswer = Integer.parseInt(br.readLine());
                switch (choiceAnswer) {
                    case 1:

                        while (!queue.isFull()) {
                            System.out.print("Ievadiet veselo skaitli: ");
                            elementToBeAdded =
                                    Integer.parseInt(
                                            br.readLine());
                            queue.enQueue(elementToBeAdded);
                        }

                        if (queue.isFull()) {
                            System.out.println("\nRinda ir pilna!" + "\n" +
                                    "Ievietot elementu vair nav iespējams!");
                        }
                        System.out.println("\nIzveidota rinda:");
                        queue.outputQueue();
                        queueCreated = true;
                        break;
                    case 2:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
                        }

                        break;
                    case 3:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
                        }
                        System.out.println("Elementu daudzums rindā: " +
                                queue.getSize());
                        break;
                    case 4:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
                        }
                        if (!queue.isEmpty()) {
                            queue.peek();
                        } else {
                            System.out.println("Rinda ir tukša");
                            continue;
                        }
                        break;
                    case 5:
                        System.out.println("Tukšuma statuss = " +
                                queue.isEmpty());
                        break;
                    case 6:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
                        }
                        if (queue.isFull()) {
                            System.out.println("Rinda ir pilna!");
                        } else {
                            System.out.println("Rinda nav pilna!");
                        }
                        break;
                    case 7:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
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
