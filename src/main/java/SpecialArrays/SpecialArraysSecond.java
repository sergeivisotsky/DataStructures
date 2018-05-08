package SpecialArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Vector;

public class SpecialArraysSecond {

    private static int[][] array = new int[10][10];
    private static Vector<Integer> vector = new Vector<>();

    /**
     * Array creation and display method
     */
    private static void arrayCreationAndOutput() {
        Random rd = new Random();

        // Array creation
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                array[i][j] = rd.nextInt(100);
            }
        }

        // Array display
        for (int[] anArray : array) {
            for (int j = 0; j <= array.length - 1; j++) {
                System.out.print(anArray[j] + "\t");
            }
            System.out.println();
        }

    }

    /**
     * Vector with non homagen creation and display
     */
    private static void vectorCreationAndOutput() {
        vector.setSize((array.length *
                (array.length + 1)) / 2);
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (array[i][j] != 0) {
                    vector.set(k, array[i][j]);
                    k++;
                }
            }
        }
        System.out.print("Vektors: " + vector);
    }

    /**
     * Linear search algorithm
     *
     * @param element   Element that should be found
     * @param getVector Vector in which should be found
     */
    private static void linearSearch(int element, Vector<Integer> getVector) {
        boolean found = false;

        for (int i = 0; i < getVector.size(); i++) {
            if (Integer.valueOf(element).equals(getVector.get(i))) {
                System.out.print(i + 1 + "\t");
                found = true;
            }
        }

        if (!found) {
            System.out.print("Elements nav atrasts!");
        }
    }

    /**
     * Insertion sort algorithm method
     *
     * @param getVectorAsInt gets vector data
     */
    private static void insertionSort(Vector<Integer> getVectorAsInt) {

        int temp;

        for (int i = 1; i < getVectorAsInt.size() - 1; i++) {

            temp = getVectorAsInt.get(i);

            int j = i - 1;

            while (j >= 0 && getVectorAsInt.get(j) < temp) {
                getVectorAsInt.setElementAt(getVectorAsInt.get(j), j + 1);
                j--;
            }

            getVectorAsInt.setElementAt(temp, j + 1);
        }
        System.out.print("\n" + "Sakārtots vektors: " + getVectorAsInt);
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
                        arrayCreationAndOutput(); // Create and display array
                        inputValueChecker = true;
                        break;
                    case 2:

                        if (!inputValueChecker) {
                            System.out.println("Sākuma nepieciešams izveidot masīvu");
                            continue;
                        }
                        vectorCreationAndOutput(); // Create and display vector
                        vectorCreated = true;
                        break;
                    case 3:

                        if (!inputValueChecker || !vectorCreated) {
                            System.out.println("Sākuma nepieciešams izveidot masīvu un vektoru");
                            continue;
                        }
                        System.out.print("\n" + "Meklēt vērtību: ");
                        int inputElement =
                                Integer.parseInt(br.readLine());
                        linearSearch(inputElement, vector); // Linear search function call
                        break;
                    case 4:

                        if (!inputValueChecker || !vectorCreated) {
                            System.out.println("Sākuma nepieciešams izveidot masīvu un vektoru");
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