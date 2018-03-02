import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ld2_30_backup {

    private static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static LinkedList<Integer>
            circularLinkedList = new LinkedList<>();

    private static void listCreationAndOutput() {
        circularLinkedList.size();
        try {

            for (int i = 0; i < 10; i++) {
                System.out.print("Pievienot elementu: ");
                int listElement = Integer.parseInt(br.readLine());
                circularLinkedList.add(listElement);
            }

            System.out.println("Izveidots saraksts: " + circularLinkedList);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Nepareizs datu formāts!");
        }
    }

    private static void deleteElementByPosition(LinkedList<Integer> getLinkedList) {
        System.out.println("Kādu elementu grībat dzēst?");
        try {
            int elementToBeDeleted = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println("Nepareizs datu formāts!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Sergejs Visockis IRDBD12 171RDB043");

        // User choose variants
        System.out.println("1: Izveidot sarakstu");
        System.out.println("2: Izmest no saraksta elementus");
        System.out.println("3: Elementu daudzums kas ir vienāds ar nulli");
        System.out.println("0: Slēgt sesiju");

        boolean inputValueChecker = false; // Checks if any value was input
        boolean endSession = false; // checks whether user closed session

        int choiceAnswer;

        try {
            do {
                System.out.println();
                System.out.print("Izvēlēties saskarsmes vērtību: ");
                choiceAnswer = Integer.parseInt(br.readLine());
                switch (choiceAnswer) {
                    case 1:
                        listCreationAndOutput();
                        inputValueChecker = true;
                        break;
                    case 2:
                        deleteElementByPosition(circularLinkedList);
                        if (!inputValueChecker) {
                            System.out.println("Sākuma nepieciešams izveidot sarakstu!");
                            continue;
                        }
                        break;
                    case 3:

                        if (!inputValueChecker) {
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
        } catch (InputMismatchException | IOException e) {
            System.out.println("Nepareizs datu formāts!");
        }
        System.out.println("Sesija slēgta...");
    }
}
