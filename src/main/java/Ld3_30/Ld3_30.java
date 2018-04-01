package Ld3_30;

import javax.print.attribute.standard.JobKOctets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

interface IQueue {
    boolean isFull();

    int getSize();

    boolean isEmpty();

    void enQueue(Object element);

    Object deQueue();

    void outputQueue();

    Object peek();

    int negativeNumberQuantity();
}

class VectorQueue implements IQueue {
    private Object queue[];
    private int maxSize;
    private int size;
    private int head;
    private int tail;

    VectorQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Object[this.maxSize];
        tail = 0;
        head = 0;
        size = 0;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enQueue(Object element) {
        queue[tail] = element;
        tail = (tail + 1) % queue.length;
        size++;
    }

    @Override
    public Object deQueue() {
        Object temp = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        size--;
        return temp;
    }

    @Override
    public void outputQueue() {
        for (Object queueElement : queue) {
            System.out.print(queueElement + "\t");
        }
    }

    @Override
    public Object peek() {
        return queue[0];
    }

    @Override
    public int negativeNumberQuantity() {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if ((int) queue[i] < 0) {
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
                System.out.print("Rindas garums (max 10): ");
                queueSize =
                        Integer.parseInt(
                                br.readLine());
                if (queueSize > 10) {
                    throw new IllegalStateException("Rindas garums nevar būt lielāks par 10!");
                }

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
                            queue.outputQueue();
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
                        throw new IllegalStateException("Ievādīta nepieņēmāma vērtība!");
                }
            } while (!endSession);
        } catch (InputMismatchException | IOException |
                NumberFormatException e) {
            System.out.println("Nepareizs datu formāts!");
        }
        System.out.println("Sesija slēgta...");
    }
}
