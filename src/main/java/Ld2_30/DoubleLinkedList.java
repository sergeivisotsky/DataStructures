package Ld2_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IList<E> {
    boolean isEmpty();

    boolean isFull();

    int getSize();

    void insert(E element);

    void output();

    void delete(E element, E position);
}

class NodeD<E> {
    private E data;
    NodeD prev;
    NodeD next;

    public NodeD(E data) {
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
        if (head == null) {
            head = node;
            node.next = head;
            node.prev = head;
            tail = head;
        }


        size++;
    }

    @Override
    public void output() {

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
            DoubleLinkedList<String> linkedList =
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
                        System.out.print("Add element: ");
                        element = input.readLine();
                        linkedList.insert(element);
                        linkedList.listCreated = true;
                        break;
                    case 2:
                        linkedList.listCreated();

                        break;
                    case 3:
                        linkedList.listCreated();
                        break;
                    case 4:
                        linkedList.listCreated();
                        break;
                    case 5:
                        linkedList.listCreated();
                        if (!linkedList.isEmpty()) {
                            System.out.print("List size: " +
                                    linkedList.getSize());
                        } else {
                            throw new IllegalStateException("List is empty!");
                        }
                        break;
                    case 6:
                        System.out.print("Empty status: " + linkedList.isEmpty());
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
