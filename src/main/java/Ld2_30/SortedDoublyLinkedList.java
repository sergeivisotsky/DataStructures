package Ld2_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

interface ISortedList extends IList {
    void insertInTheMiddle(int current);
    void insert(int current);
}

public class SortedDoublyLinkedList implements ISortedList {

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

    @Override
    public void insertAtBeginning(int element) {

    }

    @Override
    public void insertAtPosition(int element, int position) {

    }
    @Override
    public void insertInTheMiddle(int current) {

    }
    @Override
    public void insertAtEnd(int element) {

    }



    @Override
    public void insert(int current) {
        Node node = new Node(current);
        if (isEmpty()) {
            head = node;
            node.next = head;
            tail = head;
        } else if(current <= head.data) {
            insertAtBeginning(current);
        } else if (current >= tail.data) {
            insertAtEnd(current);
        } else {
            insertInTheMiddle(current);
        }
    }

    @Override
    public void display() {

    }

    @Override
    public void deleteAtPosition(int position) {

    }

    @Override
    public int negativeElementQuantity() {
        return 0;
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
            System.out.println("2: delete");
            System.out.println("3: getSize");
            System.out.println("4: isEmpty?");
            System.out.println("5: isFull?");
            System.out.println("");

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
                        }

                        if (list.isFull()) {
                            System.out.println("\nList if full!");
                        }
                        listCreated = true;
                        break;
                    case 2:
                        listCreated();
                        if (!list.isEmpty()) {
                        } else {
                            System.out.println("List is empty!");
                        }
                        break;
                    case 3:
                        listCreated();
                        System.out.println("List size: " +
                                list.getSize());
                        break;
                    case 4:
                        System.out.println("Empty status: " +
                                list.isEmpty());
                        break;
                    case 5:
                        listCreated();
                        if (list.isFull()) {
                            System.out.println("List is full!");
                        } else {
                            System.out.println("List is not full!");
                        }
                        break;
                    case 6:
                        listCreated();
                        if (!list.isEmpty()) {

                        } else {
                            System.out.println("Stack is empty!");
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
