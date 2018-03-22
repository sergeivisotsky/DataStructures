package Ld3_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

class VectorQueue {
    private VectorQueue head = null, tail = null;
    private int size = 0;

    private void enQueue() {

    }

    private void deQueue() {

    }

    private int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private boolean isFull() {
        return size == 10;
    }

    private void peek() {

    }
}

public class Ld3_30 {
    VectorQueue queue = new VectorQueue();

    public static void main(String[] args) {
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        System.out.println("Sergejs Visockis IRDBD12 171RDB043");

        // User menu to choose answer variant
        System.out.println("1: Izveidot sarakstu");
        System.out.println("2: Izmest no saraksta elementu ar konkrētu pozīciju");
        System.out.println("3: Elementu daudzums sarakstā");
        System.out.println("4: Elementu daudzums kas ir vienādi ar nulli");
        System.out.println("5: Tukšuma statuss");
        System.out.println("6: Pilnīguma statuss");
        System.out.println("0: Slēgt sesiju");

        boolean queueCreated = false; // Checks if any value was input
        boolean endSession = false; // checks whether user closed session
        int choiceAnswer; // Operation to be performed
        int elementToInput; // Element to be added to the list

        try {
            do {
                System.out.println();
                System.out.print("Izvēlēties saskarnes numuru: ");
                choiceAnswer = Integer.parseInt(br.readLine());
                switch (choiceAnswer) {
                    case 1:


                        queueCreated = true;
                        break;
                    case 2:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }

                        break;
                    case 3:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }

                        break;
                    case 4:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }

                        break;
                    case 5:

                        break;
                    case 6:
                        if (!queueCreated) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
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
