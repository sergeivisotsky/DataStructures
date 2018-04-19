package Ld3_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

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
    private Node top = null;
    private int maxSize;

    LinkedStack(int maxSize) {
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
        return top == null;
    }

    @Override
    public void push(int element) {
        Node node = new Node(element);
        if (isEmpty()) {
            top = node;
            top.next = null;
            top.prev = null;
        } else {
            top.next = node;
            node.next = null;
            node.prev = top;
            top = node;
        }
        size++;
    }

    @Override
    public void displayStack() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        Node node;
        System.out.print(top.data + "\t");

        for (node = top.prev;
             top.prev != null;
             node = node.prev) {
            System.out.print(node.data + "\t");
            top = node;
        }
    }

    @Override
    public void pop() {
        if (size == 1) {
            top = null;
            size = 0;
            return;
        }

        top = top.prev;
        top.next = null;

        size--;
    }

    @Override
    public int peek() {
        return top.data;
    }

    public int intervalNumbers() {
        int counter = 0;
        Node node;
        for (node = top;
             node.prev != null;
             node = node.prev) {
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
            int stackSize; // Stack size
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

            int choiceAnswer; // Operation to be performed
            int elementToBeAdded; // Element to be added to the list

            do {
                // User menu to choose answer variant
                System.out.println("1: push");
                System.out.println("2: pop");
                System.out.println("3: peek");
                System.out.println("4: getSize");
                System.out.println("5: isEmpty?");
                System.out.println("6: isFull?");
                System.out.println("7: intervalNumbers");
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
                        } else {
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
                        if (!stack.isEmpty()) {
                            System.out.println("Peeked element: " +
                                    stack.peek());
                        } else {
                            System.out.println("Stack is empty!");
                        }
                    case 4:
                        stackCreated();
                        System.out.println("Stack size: " +
                                stack.getSize());
                        break;
                    case 5:
                        System.out.println("Empty status: " +
                                stack.isEmpty());
                        break;
                    case 6:
                        stackCreated();
                        if (stack.isFull()) {
                            System.out.println("Stack is full!");
                        } else {
                            System.out.println("Stack is not full!");
                        }
                        break;
                    case 7:
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
                    throw new IllegalStateException("Stack is empty!");
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
