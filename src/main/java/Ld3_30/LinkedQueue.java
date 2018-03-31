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
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enQueue(Object element) {
        NodeA nodeA = new NodeA(element, null);
        if (!isFull()) {
            head = nodeA;
        } else {
            tail.next = nodeA;
        }
        tail = nodeA;
        size++;
    }

    @Override
    public Object deQueue() {
        return null;
    }

    @Override
    public void outputQueue() {
        NodeA nodeA = head;
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }

        if (head.next == head) {
            System.out.print(head.data + "\t" + nodeA.next);
            return;
        }

        System.out.print(nodeA.data + "\t");
        nodeA = head.next;

        while (nodeA.next != head) {
            System.out.print(nodeA.data + "\t");
            nodeA = nodeA.next;
        }

        System.out.print(nodeA.data + "\n");
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public int negativeNumberQuantity() {
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input =
                new BufferedReader(
                        new InputStreamReader(System.in));
        LinkedQueue linkedQueue = new LinkedQueue();
        int answer;
        int element;
        String ch;
        do {
            System.out.println("1: enQueue");
            System.out.println("2: Show queue");
            System.out.println("3: deQueue");
            System.out.println("4: peek");
            System.out.println("5: size");
            System.out.println("6: isEmpty");
            System.out.println("0: End session");
            System.out.print("\nChoose answer: ");
            answer = Integer.parseInt(input.readLine());
            switch (answer) {
                case 1:
                    element = Integer.parseInt(input.readLine());
                    linkedQueue.enQueue(element);
                    break;
                case 2:
                    linkedQueue.outputQueue();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Illegal state!");
                    break;
            }
            System.out.println("Continue? (y/n)");
            ch = input.readLine();
        } while (ch.equals("y") || ch.equals("Y"));

    }
}
