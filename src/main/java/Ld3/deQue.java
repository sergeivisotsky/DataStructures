package Ld3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IdeQue {
    void insertFirst(int element);

    void insertLast(int element);

    void display();

    void deQueueFirst();

    void deQueueLast();

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

public class deQue implements IdeQue {
    private Node head;
    private Node tail;
    private int size;
    private int maxSize;

    deQue(int maxSize) {
        this.maxSize = maxSize;
        head = null;
        tail = null;
    }

    @Override
    public void insertFirst(int element) {
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
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty!");
        }

        Node node;
        for (node = head;
             node != tail;
             node = node.next) {
            System.out.print(node.data + "\t");
        }
    }

    @Override
    public void deQueueFirst() {

    }

    @Override
    public void deQueueLast() {

    }

    @Override
    public int peekFirst() {
        return 0;
    }

    @Override
    public int peekLast() {
        return 0;
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
            deQue deQue = new deQue(deQueSize);
            int answer;
            String yesNoAnswer;
            int element;
            do {
                System.out.println("1: insertFirst");
                System.out.println("2: insertLast");
                System.out.println("3: Show deque");
                System.out.println("4: deQueueFirst");
                System.out.println("5: deQueueLast");
                System.out.println("6: peekFirst");
                System.out.println("7: peekLast");
                System.out.println("8: size");
                System.out.println("9: isEmpty");
                System.out.print("\nChoose answer: ");
                answer = Integer.parseInt(input.readLine());
                switch (answer) {
                    case 1:
                        System.out.print("Add element in the start: ");
                        element = Integer.parseInt(input.readLine());
                        deQue.insertLast(element);
                        deQueCreated = true;
                        break;
                    case 2:
                        System.out.print("Add element in the end: ");
                        deQueIsNotCreated();
//                        deQue.insertLast(element);
                        break;
                    case 3:
                        deQueIsNotCreated();
                        break;
                    case 4:
                        deQueIsNotCreated();
                        break;
                    case 5:
                        deQueIsNotCreated();
                        break;
                    case 6:
                        deQueIsNotCreated();
                        break;
                    case 7:
                        deQueIsNotCreated();
                        break;
                    case 8:
                        deQueIsNotCreated();
                        System.out.println("Queue size: " +
                                deQue.getSize());
                        break;
                    case 9:
                        System.out.println("Empty status: " +
                                deQue.isEmpty());
                        break;
                    default:
                        throw new IllegalStateException("Illegal state!");
                }
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
