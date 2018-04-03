package Ld3_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NodeA {
    Object data;
    NodeA next;

    NodeA(Object data, NodeA next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedQueue implements IQueue {
    private NodeA head = null;
    private NodeA tail = null;
    private int size = 0;

    @Override
    public boolean isFull() {
        return size == 10;
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
    public void enQueue(Object element) {
        NodeA nodeA = new NodeA(element, null);
        if (isEmpty()) {
            head = nodeA;
            nodeA.next = head;
            tail = head;
        } else {
            nodeA.next = head;
            head = nodeA;
            tail.next = nodeA;
        }
        size++;
    }

    @Override
    public Object deQueue() {
        NodeA temp = head;
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        } else if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        return temp.data;
    }

    @Override
    public void outputQueue() {
        NodeA nodeA = head;
        if (isEmpty()) {
            System.out.println("Saraksts ir tukšs!");
            return;
        }

        if (head.next == head) {
            System.out.print(head.data +
                    "\t" + nodeA.next);
            return;
        }

        System.out.print(head.data + "\t");
        nodeA = head.next;

        while (nodeA.next != head) {
            System.out.print(nodeA.data + "\t");
            nodeA = nodeA.next;
        }

        System.out.print(nodeA.data + "\n");
    }

    @Override
    public Object peek() {
        return head.data;
    }

    @Override
    public int negativeNumberQuantity() {
        NodeA nodeA;
        int counter = 0;
        if ((int) head.data < 0) {
            counter++;
        }
        for (nodeA = head;
             nodeA != tail;
             nodeA = nodeA.next) {
            if ((int) nodeA.next.data < 0) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input =
                new BufferedReader(
                        new InputStreamReader(System.in));
        LinkedQueue linkedQueue = new LinkedQueue();
        int answer;
        String yesNoAnswer;
        int element;
        do {
            System.out.println("1: enQueue");
            System.out.println("2: Show queue");
            System.out.println("3: deQueue");
            System.out.println("4: peek");
            System.out.println("5: size");
            System.out.println("6: isEmpty");
            System.out.print("\nChoose answer: ");
            answer = Integer.parseInt(input.readLine());
            switch (answer) {
                case 1:
                    System.out.print("Add element: ");
                    element = Integer.parseInt(input.readLine());
                    linkedQueue.enQueue(element);
                    break;
                case 2:
                    if (!linkedQueue.isEmpty()) {
                        linkedQueue.outputQueue();
                    } else {
                        throw new IllegalStateException("Queue is empty!");
                    }
                    break;
                case 3:
                    if (!linkedQueue.isEmpty()) {
                        System.out.print("Element to be deleted: " +
                                linkedQueue.deQueue());
                    } else {
                        throw new IllegalStateException("Queue is empty!");
                    }
                    break;
                case 4:
                    if (!linkedQueue.isEmpty()) {
                        System.out.println(linkedQueue.peek());
                    } else {
                        throw new IllegalStateException("Queue is empty!");
                    }
                    break;
                case 5:
                    if (!linkedQueue.isEmpty()) {
                        System.out.println("Queue size: " +
                                linkedQueue.getSize());
                    } else {
                        throw new IllegalStateException("Queue is empty!");
                    }
                    break;
                case 6:
                    System.out.println("Empty status: " +
                            linkedQueue.isEmpty());
                    break;
                default:
                    throw new IllegalStateException("Illegal state!");
            }
            System.out.print("\nContinue? (y/n) ");
            yesNoAnswer = input.readLine();
        } while (yesNoAnswer.equals("y") || yesNoAnswer.equals("Y"));

    }
}
