package Ld1_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Ld1_30_WithoutUtilsVector {

    private static int[][] array = new int[10][10];
    private static int[] vector =
            new int[(array.length * (array.length + 1)) / 2];

    /**
     * Array creation and output method
     */
    private static void arrayCreationAndOutput() {
        Random rd = new Random();

        // Array creation
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                array[i][j] = rd.nextInt(99) + 1;
            }
        }

        // Array output
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= array.length - 1; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

    }

    /**
     * Vector with non homagen creation and output
     */
    private static void vectorCreationAndOutput() {

        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] != 0) {
                    vector[k] = array[i][j];
                    k++;
                }
            }
        }

        System.out.println("Vektors:");
        for (int aVector : vector) {
            System.out.print(aVector + " ");
        }
    }

    /**
     * Linear search algorithm method
     *
     * @param element Searchable element
     * @param vector  One-dimensional array as a vector
     */
    private static void linearSearch(int element, int[] vector) {
        boolean found = false;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == element) {
                System.out.print((i + 1) + "\t");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Elements nav atrasts!");
        }
    }

    /**
     * Insertion sort algorithm method
     *
     * @param vector Gets vector data
     */
    private static void insertionSort(int[] vector) {
        int temp;
        for (int i = 1; i < vector.length; i++) {
            temp = vector[i];
            int j = i - 1;

            while (j >= 0 && vector[j] < temp) {
                vector[j + 1] = vector[j];
                j--;
            }

            vector[j + 1] = temp;
        }

        System.out.print("\n" + "Sakārtots vektors: ");
        for (int aVector : vector) {
            System.out.print(aVector + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Sergejs Visockis IRDBD12 171RDB043");
        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        // User choose variants
        System.out.println("1: Masīva aizpildīšana ar gadījuma vērtībām un tā izvade");
        System.out.println("2: Nehomogēnu elementu ierakstīšana vektorā");
        System.out.println("3: Vektora elementu meklēšana ar sec. mekl. alg. (Linear search)");
        System.out.println("4: Vektora kārtošana ar iespraušanu un tā izvade (Insertion sort)");
        System.out.println("0: Sesijas beigas");

        boolean inputValueChecker = false; // Checks if any value was input
        boolean vectorCreated = false; // Checks if vector was created
        boolean endSession = false; // checks whether user closed session

        int choiceAnswer;

        try {
            do {
                System.out.println();
                System.out.print("Izvēlēties saskarsmes vērtību: ");
                choiceAnswer =
                        Integer.parseInt(br.readLine());
                switch (choiceAnswer) {
                    case 1:
                        arrayCreationAndOutput(); // Create and output array
                        inputValueChecker = true;
                        break;
                    case 2:

                        if (!inputValueChecker) {
                            System.out.println("Sākuma nepieciešams izveidot masīvu!");
                            continue;
                        }
                        vectorCreationAndOutput(); // Create and output vector
                        vectorCreated = true;
                        break;
                    case 3:

                        if (!inputValueChecker || !vectorCreated) {
                            System.out.println("Sākuma nepieciešams izveidot masīvu un vektoru!");
                            continue;
                        }
                        System.out.print("\n" + "Meklēt vērtību: ");
                        int inputElement =
                                Integer.parseInt(br.readLine());
                        linearSearch(inputElement, vector); // Linear search function call
                        break;
                    case 4:

                        if (!inputValueChecker || !vectorCreated) {
                            System.out.println("Sākuma nepieciešams izveidot masīvu un vektoru!");
                            continue;
                        }

                        insertionSort(vector); // Insertion sort function call
                        break;
                    case 0:
                        endSession = true;
                        break;
                    default:
                        System.out.print("Ievādīta nepieņēmāma vērtība!");
                }
            } while (!endSession);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Nepareizs datu formāts!");
        }
        System.out.println("Sesija pabeigts...");
    }
}