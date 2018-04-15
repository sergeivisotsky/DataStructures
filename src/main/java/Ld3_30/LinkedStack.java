package Ld3_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

interface IStack {
    boolean isFull();

    int getSize();

    boolean isEmpty();

    void push(int element);

    void displayStack();

    void pop();

    int intervalNumbers();
}

public class LinkedStack implements IStack {

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private int size = 0;
    private Node head = null;
    private Node tail = null;
    public int maxSize;

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
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
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(int element) {
        Node node = new Node(element);
        if (isEmpty()) {
            head = node;
            tail = head;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public void displayStack() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        if (head.next == null) {
            System.out.print(head.data);
            return;
        }
        Node node;
        System.out.print(head.data + "\t");
        node = head.next;

        while (node.next != null) {
            System.out.print(node.data + "\t");
            node = node.next;
        }
    }

    @Override
    public void pop() {
        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        head = head.next;
        head.prev = null;
        size--;
    }

    @Override
    public int intervalNumbers() {
        int counter = 0;
        Node node;
        for (node = head;
             node != tail;
             node = node.next) {
            if (node.data >= -10 && node.data <= 10) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean stackCreated = false; // Checks if queue was created
    public static void main(String[] args) {
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));
        try {
            int stackSize; // Queue size
            System.out.print("Stack size (max 10): ");
            stackSize =
                    Integer.parseInt(
                            br.readLine());
            if (stackSize > 10) {
                throw new IllegalStateException("Stack size should not be greater than 10!");
            }
            String yesNoAnswer;
            LinkedStack stack =
                    new LinkedStack(stackSize);
            // User menu to choose answer variant
            System.out.println("1: push");
            System.out.println("2: pop");
            System.out.println("3: getSize");
            System.out.println("4: isEmpty?");
            System.out.println("5: isFull?");
            System.out.println("6: intervalNumbers");

            boolean endSession = false; // checks whether user closed session
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
                        if (!stack.isFull()) {
                            System.out.print("Number: ");
                            elementToBeAdded =
                                    Integer.parseInt(
                                            br.readLine());
                            stack.push(elementToBeAdded);
                        }

                        if (stack.isFull()) {
                            System.out.println("\nStack if full!");
                        }
                        stackCreated = true;
                        break;
                    case 2:
                        stackCreated();
                        if (!stack.isEmpty()) {
                            stack.pop();
                        } else {
                            System.out.println("Stack is empty!");
                        }
                        break;
                    case 3:
                        stackCreated();
                        System.out.println("Stack size: " +
                                stack.getSize());
                        break;
                    case 4:
                        System.out.println("Empty status: " +
                                stack.isEmpty());
                        break;
                    case 5:
                        stackCreated();
                        if (stack.isFull()) {
                            System.out.println("Stack is full!");
                        } else {
                            System.out.println("Stack is not full!");
                        }
                        break;
                    case 6:
                        stackCreated();
                        if (!stack.isEmpty()) {
                            System.out.println("Number of elements in interval [-10; 10]: " +
                                    stack.intervalNumbers());
                        } else {
                            System.out.println("Stack is empty!");
                        }
                        break;
                    default:
                        throw new IllegalStateException("Number is not allowed!");
                }
                if (!stack.isEmpty()) {
                    System.out.println("Created stack: ");
                    stack.displayStack();
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

    private static void stackCreated() {
        if (!stackCreated) {
            System.out.println("Stack is not created!");
        }
    }
}
