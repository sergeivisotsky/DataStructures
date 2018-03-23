package Ld3_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

class VectorQueue {
    private int[] queue;
    private int maxSize;
    private int size;
    private int head;
    private int tail;

    VectorQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        tail = -1;
        head = 0;
        size = 0;
    }

    public boolean isFull() {
        return size == 10;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(int element) {
        if (isEmpty()) {
            if (tail == maxSize - 1) {
                tail = -1;
            }

            queue[++tail] = element;
        }
        size++;
    }

    public void deQueue() {
//        int temp = queue[head++];
        if (head == maxSize) {
            head = 0;
        }
        size--;
    }

    public void outputQueue() {
        for (int aQueue : queue) {
            System.out.print(aQueue + "\t");
        }
    }

    public int peek() {
        return queue[0];
    }
}

public class Ld3_30 {
    private static VectorQueue queue =
            new VectorQueue(10);

    public static void main(String[] args) {
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        System.out.println("Sergejs Visockis IRDBD12 171RDB043");

        // User menu to choose answer variant
        System.out.println("1: Pievienot elementu rindā");
        System.out.println("2: Izmest elementu no rindas");
        System.out.println("3: Elementu daudzums rindā");
        System.out.println("4: Radīt pirmo elementu");
        System.out.println("5: Tukšuma statuss");
        System.out.println("6: Pilnīguma statuss");
        System.out.println("7: Negatīvu elementu daudzums");
        System.out.println("0: Slēgt sesiju");

        boolean queueCreated = false; // Checks if any value was input
        boolean endSession = false; // checks whether user closed session
        int choiceAnswer; // Operation to be performed
        int elementToBeAdded; // Element to be added to the list

        try {
            do {
                System.out.println();
                System.out.print("Izvēlēties saskarnes numuru: ");
                choiceAnswer = Integer.parseInt(br.readLine());
                switch (choiceAnswer) {
                    case 1:

                        while (!queue.isFull()) {
                            System.out.print("Ievadiet veselo skaitli: ");
                            elementToBeAdded =
                                    Integer.parseInt(
                                            br.readLine());
                            queue.enQueue(elementToBeAdded);
                        }

                        if (queue.isFull()) {
                            System.out.println("\nRinda ir pilna!" + "\n" +
                                    "Ievietot elementu vairs nav iespējams!");
                        }
                        System.out.println("\nIzveidota rinda:");
                        queue.outputQueue();
                        queueCreated = true;
                        break;
                    case 2:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
                        }

                        if (!queue.isEmpty()) {
                            queue.deQueue();
                        } else {
                            System.out.println("Rinda ir tukša!");
                            continue;
                        }
                        break;
                    case 3:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
                        }
                        System.out.println("Elementu daudzums rindā: " +
                                queue.getSize());
                        break;
                    case 4:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
                        }

                        if (!queue.isEmpty()) {
                            System.out.print(queue.peek());
                        }
                        break;
                    case 5:
                        System.out.println("Tukšuma statuss = " +
                                queue.isEmpty());
                        break;
                    case 6:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
                        }
                        if (queue.isFull()) {
                            System.out.println("Rinda ir pilna!");
                        } else {
                            System.out.println("Rinda nav pilna!");
                        }
                        break;
                    case 7:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot rindu!");
                            continue;
                        }
                        break;
                    case 0:
                        endSession = true;
                        break;
                    default:
                        System.out.print("Ievādīta nepieņēmāma vērtība!");
                }
            } while (!endSession);
        } catch (InputMismatchException | IOException |
                NumberFormatException e) {
            System.out.println("Nepareizs datu formāts!");
        }
        System.out.println("Sesija slēgta...");
    }
}
