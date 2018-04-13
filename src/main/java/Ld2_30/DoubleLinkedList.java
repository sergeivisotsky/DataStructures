package Ld2_30;

import Ld3_30.LinkedQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

interface IList<E> {
    boolean isEmpty();

    boolean isFull();

    int getSize();

    void insert(E element);

    void display();

    void delete(E element, E position);
}

class NodeD<E> {
    E data;
    NodeD prev;
    NodeD next;

    NodeD(E data) {
        this.data = data;
    }
}

public class DoubleLinkedList<E> implements IList<E> {

    private NodeD head = null;
    private NodeD tail = null;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return size == 10;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void insert(E element) {
        NodeD<E> node = new NodeD<>(element);
        // TODO: Insert function up to the end!!!!!!!
        if (isEmpty()) {
            head = node;
            node.prev = head;
            node.next = node;
            tail = head;
        } else {
            node.next = head;
            node.next = node.prev;
            node.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void display() {
        NodeD<E> node = head;
        // TODO: Display function up to the end!!!!!!!!
        if (!isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }

        if (head.next == head) {
            System.out.print(head.data + "\t" +
                    node.prev + "\t" + node.next);
        }
    }

    @Override
    public void delete(E element, E position) {

    }

    private boolean listCreated = false;

    public static void main(String[] args) {
        BufferedReader input =
                new BufferedReader(
                        new InputStreamReader(System.in));
        try {
            DoubleLinkedList<String> list =
                    new DoubleLinkedList<String>();
            int answer;
            String yesNoAnswer;
            String element;

            do {
                System.out.println("1: Add element");
                System.out.println("2: Show list");
                System.out.println("3: deQueue");
                System.out.println("4: Delete element");
                System.out.println("5: Size");
                System.out.println("6: Empty?");
                System.out.print("\nChoose answer: ");
                answer = Integer.parseInt(input.readLine());
                switch (answer) {
                    case 1:
                        if (!list.isFull()) {
                            System.out.print("Add element: ");
                            element = input.readLine();
                            list.insert(element);
                        } else {
                            System.out.println("List is empty!");
                        }
                        list.listCreated = true;
                        break;
                    case 2:
                        list.listCreated();
                        if (!list.isEmpty()) {
                            list.display();
                        }
                        break;
                    case 3:
                        list.listCreated();
                        break;
                    case 4:
                        list.listCreated();
                        break;
                    case 5:
                        list.listCreated();
                        if (!list.isEmpty()) {
                            System.out.print("List size: " +
                                    list.getSize());
                        } else {
                            throw new IllegalStateException("List is empty!");
                        }
                        break;
                    case 6:
                        System.out.print("Empty status: " + list.isEmpty());
                        break;
                    default:
                        throw new IllegalStateException("Illegal state!");
                }
                System.out.print("\nContinue? (y/n) ");
                yesNoAnswer = input.readLine();
            } while (yesNoAnswer.equals("y") || yesNoAnswer.equals("Y"));
        } catch (IOException e) {
            System.out.println("Invalid state!");
        }

    }

    private void listCreated() {
        if (!listCreated) {
            System.out.println("List is not created!");
        }
    }

}
