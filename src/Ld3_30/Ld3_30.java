package Ld3_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

class VectorQueue {
    private int[] queue;
    private int[] tempQueue;
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
        return size == maxSize;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(int element) {
        if (!isFull()) {
            if (tail == maxSize - 1) {
                tail = -1;
            }

            queue[++tail] = element;
        }
        size++;
    }


    public int deQueue() {
        int temp = queue[tail++];
        tempQueue = new int[maxSize - 1];
        if (tail == maxSize) {
            /*System.arraycopy(queue, 0, tempQueue,
                    0, size - 1);*/
            for (int i = 0; i < size - 1; i++) {
                tempQueue[i] = queue[i];
            }
        }
        size--;
        return temp;
    }

    public void outputQueueWithDeleted() {
        for (int queueElement : tempQueue) {
            System.out.print(queueElement + "\t");
        }
    }

    public void outputQueue() {
        for (int queueElement : queue) {
            System.out.print(queueElement + "\t");
        }
    }

    public int peek() {
        return queue[0];
    }

    public int negativeNumberQuantity() {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (queue[i] < 0) {
                counter++;
            }
        }
        return counter;
    }
}

public class Ld3_30 {
    public static void main(String[] args) {
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));
        try {
            int queueSize; // Queue size
            System.out.println("Sergejs Visockis IRDBD12 171RDB043");
            do {
                System.out.print("Rindas garums (max 10): ");
                queueSize =
                        Integer.parseInt(
                                br.readLine());
                if (queueSize > 10) {
                    System.out.print("Rindas garums nevar būt lielāks par 10!");
                }
            } while (queueSize > 10);

            VectorQueue queue =
                    new VectorQueue(queueSize);
            // User menu to choose answer variant
            System.out.println("1: Pievienot elementu rindā");
            System.out.println("2: Izmest elementu no rindas");
            System.out.println("3: Elementu daudzums rindā");
            System.out.println("4: Radīt pirmo elementu");
            System.out.println("5: Tukšuma statuss");
            System.out.println("6: Pilnīguma statuss");
            System.out.println("7: Negatīvu elementu daudzums");
            System.out.println("0: Slēgt sesiju");

            boolean queueCreated = false; // Checks if queue was created
            boolean endSession = false; // checks whether user closed session
            int choiceAnswer; // Operation to be performed

            int elementToBeAdded; // Element to be added to the list


            do {
                System.out.println();
                System.out.print("Izvēlēties saskarnes vērtību: ");
                choiceAnswer =
                        Integer.parseInt(
                                br.readLine());
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
                            System.out.print("Izejas elements: " +
                                    queue.deQueue());
                            System.out.println("\nIzveidota rinda:");
//                            queue.outputQueue();
                            queue.outputQueueWithDeleted();
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

                        System.out.println(queue.negativeNumberQuantity());
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
