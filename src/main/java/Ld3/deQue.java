package Ld3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IdeQue {
    void insertAtStart(int element);

    void insertAtEnd(int element);

    void display();

    void deQueueAtStart();

    void deQueueInTheEnd();

    int peekAtStart();

    int peekAtTheEnd();

    boolean isFull();

    boolean isEmpty();

    int getSize();
}

class Node {
    int data;
    Node next;
    Node prev;

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
    public void insertAtStart(int element) {
        Node node = new Node(element);
        if (isFull()) {
            head = node;
            head.next = null;
            head.prev = null;
        } else {
            head.next = node;
            node.next = null;
            node.prev = head;
            head = node;
        }

        size++;
    }

    @Override
    public void insertAtEnd(int element) {

    }

    @Override
    public void display() {

    }

    @Override
    public void deQueueAtStart() {

    }

    @Override
    public void deQueueInTheEnd() {

    }

    @Override
    public int peekAtStart() {
        return 0;
    }

    @Override
    public int peekAtTheEnd() {
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
                System.out.println("1: insertAtStart");
                System.out.println("2: insertAtEnd");
                System.out.println("3: Show deque");
                System.out.println("4: deQueueAtStart");
                System.out.println("5: deQueueInTheEnd");
                System.out.println("6: peekAtStart");
                System.out.println("7: peekAtTheEnd");
                System.out.println("8: size");
                System.out.println("9: isEmpty");
                System.out.print("\nChoose answer: ");
                answer = Integer.parseInt(input.readLine());
                switch (answer) {
                    case 1:
                        System.out.print("Add element in the start: ");
                        element = Integer.parseInt(input.readLine());
                        deQue.insertAtEnd(element);
                        deQueCreated = true;
                        break;
                    case 2:
                        System.out.print("Add element in the end: ");
                        deQueIsNotCreated();
//                        deQue.insertAtEnd(element);
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
