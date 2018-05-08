package QueuesStacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IDoubleEndedQueue {
    void insertFirst(int element);

    void insertLast(int element);

    void display();

    int deQueueFirst();

    int deQueueLast();

    int peekFirst();

    int peekLast();

    boolean isFull();

    boolean isEmpty();

    int getSize();
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class DoubleEndedQueue implements IDoubleEndedQueue {
    private Node head;
    private Node tail;
    private int size;
    private int maxSize;

    DoubleEndedQueue(int maxSize) {
        this.maxSize = maxSize;
        head = null;
        tail = null;
    }

    private void fullStatusChecker() {
        if (isFull()) {
            throw new IllegalStateException("DeQue is full!");
        }
    }

    private void emptyStatusChecker() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }
    }

    @Override
    public void insertFirst(int element) {
        fullStatusChecker();
        Node node = new Node(element);
        if (isEmpty()) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head = node;
        }

        size++;
    }

    @Override
    public void insertLast(int element) {
        fullStatusChecker();
        Node node = new Node(element);
        if (isEmpty()) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    @Override
    public void display() {
        emptyStatusChecker();
        Node node;
        for (node = head;
             node != tail.next;
             node = node.next) {
            System.out.print(node.data + "\t");
        }
    }

    @Override
    public int deQueueFirst() {
        emptyStatusChecker();
        Node node = head;
        head = node.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return node.data;
    }

    @Override
    public int deQueueLast() {
        emptyStatusChecker();
        int temp = tail.data;
        Node first = head;
        Node second = head;
        while (first != tail) {
            second = first;
            first = first.next;
        }
        tail = second;
        tail.next = null;
        size--;
        return temp;
    }

    @Override
    public int peekFirst() {
        return head.data;
    }

    @Override
    public int peekLast() {
        return tail.data;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private static boolean deQueCreated = false;

    public static void main(String[] args) {
        try (BufferedReader input =
                     new BufferedReader(
                             new InputStreamReader(System.in))) {
            int deQueSize;
            System.out.println("deQue implementation");
            System.out.print("deQue size (max 15): ");
            deQueSize = Integer.parseInt(input.readLine());
            if (deQueSize > 10) {
                throw new IllegalStateException("Size shouldn't be greater than 10!");
            }
            DoubleEndedQueue deQue = new DoubleEndedQueue(deQueSize);
            int answer;
            String yesNoAnswer;
            int element;
            do {
                System.out.println();
                System.out.println("1: insertFirst");
                System.out.println("2: insertLast");
                System.out.println("3: deQueueFirst");
                System.out.println("4: deQueueLast");
                System.out.println("5: peekFirst");
                System.out.println("6: peekLast");
                System.out.println("7: size");
                System.out.println("8: isEmpty");
                System.out.print("\nChoose answer: ");
                answer = Integer.parseInt(input.readLine());
                switch (answer) {
                    case 1:
                        System.out.print("Add element in the start: ");
                        element = Integer.parseInt(input.readLine());
                        deQue.insertFirst(element);
                        deQueCreated = true;
                        break;
                    case 2:
                        System.out.print("Add element in the end: ");
                        element = Integer.parseInt(input.readLine());
                        deQue.insertLast(element);
                        deQueIsNotCreated();
                        break;
                    case 3:
                        deQueIsNotCreated();
                        System.out.println("Deleted first element: " +
                                deQue.deQueueFirst());
                        break;
                    case 4:
                        deQueIsNotCreated();
                        System.out.println("Deleted last element: " +
                                deQue.deQueueLast());
                        break;
                    case 5:
                        deQueIsNotCreated();
                        System.out.println("First element: " +
                                deQue.peekFirst());
                        break;
                    case 6:
                        deQueIsNotCreated();
                        System.out.println("Last element: " +
                                deQue.peekLast());
                        break;
                    case 7:
                        deQueIsNotCreated();
                        System.out.println("Queue size: " +
                                deQue.getSize());
                        break;
                    case 8:
                        System.out.println("Empty status: " +
                                deQue.isEmpty());
                        break;
                    default:
                        throw new IllegalStateException("Illegal state!");
                }

                System.out.println("\nCreated deque:");
                deQue.display();
                System.out.println();
                System.out.print("\nContinue? (y/n) ");
                yesNoAnswer = input.readLine();
            } while (yesNoAnswer.equals("y") || yesNoAnswer.equals("Y"));
        } catch (IOException e) {
            System.out.println("Input output error!");
        }
    }

    private static void deQueIsNotCreated() {
        if (!deQueCreated) {
            System.out.println("DeQue is not created!");
        }
    }
}
