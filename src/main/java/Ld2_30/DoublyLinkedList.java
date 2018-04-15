package Ld2_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IList {
    boolean isEmpty();

    boolean isFull();

    int getSize();

    void insertAtBeginning(int element);

    void insertAtPosition(int element, int position);

    void insertAtEnd(int element);

    void display();

    void deleteAtPosition(int position);

    int negativeElementQuantity();
}

class NodeD {
    int data;
    NodeD prev;
    NodeD next;

    NodeD(int data) {
        this.data = data;
    }
}

public class DoublyLinkedList implements IList {

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
    public void insertAtBeginning(int element) {
        NodeD node = new NodeD(element);
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
    public void insertAtPosition(int element, int position) {
        NodeD node = new NodeD(element);
        if (position == 1) {
            insertAtBeginning(element);
            return;
        }

        NodeD ptr = head;

        for (int i = 2; i <= size; i++) {
            if (i == position) {
                NodeD temp = ptr.next;
                ptr.next = node;
                node.prev = ptr;
                node.next = temp;
                temp.prev = node;
            }

            ptr = ptr.next;
        }

        size++;
    }

    @Override
    public void insertAtEnd(int element) {
        NodeD node = new NodeD(element);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void display() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }

        if (head.next == null) {
            System.out.print(head.data);
            return;
        }

        NodeD node;
        System.out.print(head.data + "\t");
        node = head.next;

        while (node.next != null) {
            System.out.print(node.data + "\t");
            node = node.next;
        }

        System.out.print(node.data + "\t");
    }

    @Override
    public void deleteAtPosition(int position) {
        if (position == 1) {
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return;
            }

            head = head.next;
            head.prev = null;
            size--;
            return;
        }

        if (position == size) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }

        NodeD node = head.next;
        for (int i = 2; i <= size; i++) {
            if (i == position) {
                NodeD prevPtr = node.prev;
                NodeD nextPtr = node.next;
                prevPtr.next = nextPtr;
                nextPtr.prev = prevPtr;
                size--;
                return;
            }
            node = node.next;
        }
    }

    @Override
    public int negativeElementQuantity() {
        NodeD node;
        int counter = 0;
        for (node = head;
             node != tail;
             node = node.next) {

            if (node.data < 0) {
                counter++;
            }
        }

        return counter;
    }

    private boolean listCreated = false;

    public static void main(String[] args) {
        BufferedReader input =
                new BufferedReader(
                        new InputStreamReader(System.in));
        try {
            DoublyLinkedList list = new DoublyLinkedList();
            int answer;
            String yesNoAnswer;
            int element;
            int position;

            do {
                System.out.println("1: insertElementAtBeginning");
                System.out.println("2: insertAtPosition");
                System.out.println("3: insertAtEnd");
                System.out.println("4: Delete data");
                System.out.println("5: negativeElementQuantity");
                System.out.println("6: Size");
                System.out.println("7: Empty?");
                System.out.print("\nChoose answer: ");
                answer = Integer.parseInt(input.readLine());
                switch (answer) {
                    case 1:
                        if (!list.isFull()) {
                            System.out.print("Add data: ");
                            element = Integer.parseInt(input.readLine());
                            list.insertAtBeginning(element);
                        } else {
                            System.out.println("List is full!");
                        }
                        list.listCreated = true;
                        break;
                    case 2:
                        if (!list.isFull()) {
                            System.out.print("Element: ");
                            element = Integer.parseInt(input.readLine());
                            System.out.print("Position: ");
                            position = Integer.parseInt(input.readLine());
                            list.insertAtPosition(element, position);
                        } else {
                            System.out.println("List is full!");
                        }
                        break;
                    case 3:
                        if (!list.isFull()) {
                            System.out.print("Add data: ");
                            element = Integer.parseInt(input.readLine());
                            list.insertAtEnd(element);
                        } else {
                            System.out.println("List is full!");
                        }
                        break;
                    case 4:
                        list.listCreated();
                        if (!list.isEmpty()) {
                            System.out.print("Input position: ");
                            position = Integer.parseInt(input.readLine());
                            list.deleteAtPosition(position);
                        } else {
                            throw new IllegalStateException("List is empty!");
                        }
                        break;
                    case 5:
                        list.listCreated();
                        if (!list.isEmpty()) {
                            System.out.print("Negative data quantity: ");
                            list.negativeElementQuantity();
                        } else {
                            throw new IllegalStateException("List is empty!");
                        }
                        break;
                    case 6:
                        list.listCreated();
                        if (!list.isEmpty()) {
                            System.out.print("List size: " +
                                    list.getSize());
                        } else {
                            throw new IllegalStateException("List is empty!");
                        }
                        break;
                    case 7:
                        System.out.print("Empty status: " + list.isEmpty());
                        break;
                    default:
                        throw new IllegalStateException("Illegal state!");
                }
                if (!list.isEmpty()) {
                    System.out.println("Created list: ");
                    list.display();
                } else {
                    throw new IllegalStateException("List is empty!");
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
