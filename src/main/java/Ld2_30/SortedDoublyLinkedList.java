package Ld2_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

interface ISortedDoublyLinkedList {
    boolean isEmpty();

    boolean isFull();

    int getSize();

    void insert(int current);

    void display();

    void deleteAtPosition(int position);
}

public class SortedDoublyLinkedList implements ISortedDoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int maxSize;
    private int size = 0;

    public SortedDoublyLinkedList(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void insertAtBeginning(int current) {
        Node node = new Node(current);
        node.prev = tail;
        tail.next = node;
        head.prev = node;
        node.next = head;
        head = node;
    }

    private void insertInTheMiddle(int current) {
        Node node = new Node(current);
        Node temp, ptr;
        boolean inserted = false;
        temp = head;
        ptr = head.next;
        while (ptr != null) {
            if (current >= temp.data &&
                    current <= ptr.data) {
                temp.next = node;
                node.prev = temp;
                node.next = ptr;
                ptr.prev = node;
                inserted = true;
                break;
            } else {
                temp = ptr;
                ptr = ptr.next;
            }
        }
        if (!inserted) {
            temp.next = node;
            node.prev = temp;
        }
    }

    private void insertAtEnd(int current) {
        Node node = new Node(current);
        tail.next = node;
        node.prev = tail;
        node.next = head;
        head.prev = node;
        tail = node;
    }


    @Override
    public void insert(int current) {
        Node node = new Node(current);
        if (isEmpty()) {
            node.next = node;
            node.prev = node;
            head = node;
            tail = head;
        } else if (current <= head.data) {
            insertAtBeginning(current);
        } else if (current >= tail.data) {
            insertAtEnd(current);
        } else {
            insertInTheMiddle(current);
        }
        size++;
    }

    @Override
    public void display() {
        Node node = head;
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        if (head.next == head) {
            System.out.print(head.data + "\t" + node.data + "\n");
            return;
        }

        System.out.print(head.data + "\t");
        node = head.next;

        while (node.next != head) {
            System.out.print(node.data + "\t");
            node = node.next;
        }
        System.out.print(node.data + "\t");
    }

    @Override
    public void deleteAtPosition(int position) {

    }

    public int intervalNumbers() {
        int counter = 0;

        return counter;
    }

    private static boolean listCreated = false; // Checks if queue was created

    public static void main(String[] args) {
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));
        try {
            int stackSize; // Stack size
            System.out.print("List size (max 10): ");
            stackSize =
                    Integer.parseInt(
                            br.readLine());
            if (stackSize > 10) {
                throw new IllegalStateException("List size should not be greater than 10!");
            }
            String yesNoAnswer;
            SortedDoublyLinkedList list =
                    new SortedDoublyLinkedList(stackSize);
            // User menu to choose answer variant
            System.out.println("1: Insert");
            System.out.println("2: DeleteAtPosition");
            System.out.println("3: Interval [-10; 10]");
            System.out.println("4: getSize");
            System.out.println("5: isEmpty?");
            System.out.println("6: isFull?");

            int choiceAnswer; // Operation to be performed
            int elementToBeAdded; // Element to be added to the list

            do {
                System.out.println();
                System.out.print("Answer: ");
                choiceAnswer =
                        Integer.parseInt(
                                br.readLine());
                switch (choiceAnswer) {
                    case 1:
                        if (!list.isFull()) {
                            System.out.print("Number: ");
                            elementToBeAdded =
                                    Integer.parseInt(
                                            br.readLine());
                            list.insert(elementToBeAdded);
                        }

                        if (list.isFull()) {
                            System.out.println("\nList if full!");
                        }
                        listCreated = true;
                        break;
                    case 2:
                        if (!list.isEmpty()) {
                            System.out.print("Position: ");
                            int position =
                                    Integer.parseInt(br.readLine());
                            list.deleteAtPosition(position);
                        } else {
                            throw new IllegalStateException("List is empty!");
                        }
                        break;
                    case 3:
                        if (!list.isEmpty()) {
                            System.out.print("Quantity: " +
                                    list.intervalNumbers());
                        } else {
                            throw new IllegalStateException("List is empty!");
                        }
                        break;
                    case 4:
                        listCreated();
                        if (!list.isEmpty()) {
                            System.out.print("List size: " +
                                    list.getSize());
                        } else {
                            System.out.println("List is empty!");
                        }
                        break;
                    case 5:
                        System.out.println("Empty status: " +
                                list.isEmpty());
                        break;
                    case 6:
                        listCreated();
                        if (list.isFull()) {
                            System.out.println("List is full!");
                        } else {
                            System.out.println("List is not full!");
                        }
                        break;
                    default:
                        throw new IllegalStateException("Number is not allowed!");
                }
                if (!list.isEmpty()) {
                    System.out.println("Created list: ");
                    list.display();
                } else {
                    throw new IllegalStateException("List is empty!");
                }
                System.out.print("\nContinue? (y/n) ");
                yesNoAnswer = br.readLine();
            } while (yesNoAnswer.equals("y") || yesNoAnswer.equals("Y"));
        } catch (InputMismatchException | IOException |
                NumberFormatException e) {
            System.out.println("Incorrect input data!");
        }
        System.out.println("Session closed...");
    }

    private static void listCreated() {
        if (!listCreated) {
            System.out.println("Stack is not created!");
        }
    }
}
