package Ld1_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Ld1_Example {
    // Tiek izpildiita vektora kaartosana ar iesprausanu
    public int[] insertionSort(int array[]) {
        int temp;
        int pos;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            pos = i - 1;
            while ((pos >= 0) && (temp < array[pos])) {
                array[pos + 1] = array[pos];
                pos--;
            }
            array[pos + 1] = temp;
        }
        return array;
    }

    //Tiek izpildiita vektora kaartosana ar izveeli
    public int[] selectionSort(int array[]) {
        for (int i = array.length - 1; i > 0; i--) {
            int first = 0;
            for (int j = 1; j <= i; j++) {
                if (array[j] < array[first])
                    first = j;
            }
            int temp = array[first];
            array[first] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int A[][] = new int[10][10];    // Matricas inicializaacija
        int B[] = new int[10];            // Vektora inicializaacija
        int C[] = new int[10];            // Vektora inicializaacija
        int D[] = new int[10];            // Vektora inicializaacija
        boolean mat = false;            // Mainiigaa mat defineesana ar staavokli false
        boolean arr = false;            // Mainiigaa arr defineesana ar staavokli false
        int searchKey;                    // Mainiigaa searchKey defineesana
        int a, i, j, c = 0;
        String st;
        Ld1_Example insertion = new Ld1_Example();
        Ld1_Example selection = new Ld1_Example();
        Random rnd = new Random();

        System.out.println("Datis Strukturis RDBD0 000RDB007");
        System.out.println();

        Scanner in = new Scanner(System.in);
        // Izvada izveelni
        System.out.println("Masiva aizpildisana ar gadijuma vertibam     : 1");
        System.out.println("Masiva homogenu vertibu ierakstisana vektora : 2");
        System.out.println("Vektora elementa lineara algoritma meklesana : 3");
        System.out.println("Vektora elementa ar robezmarkiera  meklesanu : 4");
        System.out.println("Vektora skirosana ar iesprausanu (Insertion) : 5");
        System.out.println("Vektora skirosana ar izveli (Selection)      : 6");
        System.out.println("Ja velaties iziet no sistemas nospiediet     : 0");

        boolean quit = false;            // Mainiigaa quit defineesana ar staavokli false
        int menuItem;
        do {
            System.out.println();
            System.out.println("Izvelieties saskarnes vertibu : ");
            menuItem = in.nextInt();            // Mainiigajam menuItem pieskir case veertiibu skaitu
            switch (menuItem) {
                // Izveelnes pirmaa punkta realizaacija. Matricas aizpildisana ar patvaliigaam veertiibaam
                case 1:
                    for (i = 0; i <= 9; i++)
                        for (j = 0; j <= 9; j++)
                            if (j == i) {
                                A[i][j] = rnd.nextInt(10) + 1;
                            }
                    System.out.println();
                    System.out.println();

                    for (i = 0; i <= 9; i++) {
                        for (j = 0; j <= 9; j++)
                            System.out.print(A[i][j] + "\t");
                        System.out.println();
                    }
                    mat = true;
                    break;
                // Izveelnes otraa punkta realizaacija. Vektora aizpildisana ar patvaliigaam veertiibaam
                case 2:
                    if (!mat) {
                        System.out.println("Sakuma nepieciesams izveidot masivu");
                        continue;
                    }
                    for (i = 0; i <= 9; i++)
                        for (j = 0; j <= 9; j++)
                            if (j == i) {
                                B[i] = A[i][j];
                            }
                    System.out.print("Iegutais vektors ir  :   ");
                    for (int aB : B) {
                        System.out.print(aB + " ");
                    }
                    arr = true;
                    System.out.println();
                    break;
                // Izveelnes tresaa punkta realizaacija. Izveeleetaas veertiibas atrasana izmantojot lineaaro algoritmu
                case 3:
                    c = 0;
                    if (!mat || !arr) {
                        System.out.println("Sakuma nepieciesams izveidot masivu un vektoru");
                        continue;
                    }
                    System.out.println("Ievadiet vektora vertibu, kuru velaties atrast");
                    try {
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(System.in));
                        st = br.readLine();
                        searchKey = Integer.parseInt(st);
                    } catch (Exception e) {
                        System.out.println("input-output error");
                        return;
                    }
                    for (i = 0; i < B.length; i++) {
                        boolean found = false;

                        if (B[i] == searchKey) {
                            found = true;
                        }
                        if (found) {
                            System.out.println(searchKey + " Vertiba atrasta pozicija " + (i + 1));
                            c++;
                        }
                        if (c == 0 && i == B.length - 1) {
                            System.out.println("Vertiba  " + searchKey + " netika atrasta...!");
                        }
                    }
                    c = 0;
                    break;
                // Izveelnes ceturtaa punkta realizaacija. Izveeleetaas veertiibas atrasana izmantojot robezmarkiera  mekleesanu
                case 4:
                    c = 0;
                    if (!mat || !arr) {
                        System.out.println("Sakuma nepieciesams izveidot masivu un vektoru");
                        continue;
                    }
                    boolean found = false;
                    System.out.println("Ievadiet vetora vertibu, kuru velaties atrast");
                    try {
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(System.in));
                        st = br.readLine();
                        searchKey = Integer.parseInt(st);
                    } catch (Exception e) {
                        System.out.println("input-output error");
                        return;
                    }

                    while (!found && c < B.length) {
                        if (B[c] == searchKey)
                            found = true;
                        else c++;
                        if (found)
                            System.out.println("Vertiba  " + searchKey + " atrasta pozicija " + (c + 1));
                        if (c == B.length)
                            System.out.println("Vertiba  " + searchKey + " netika atrasta...!");
                    }
                    c = 0;
                    break;
                // Izveelnes piektaa punkta realizaacija. Vektora sakaartosana izmantojot iesprausanu
                case 5:
                    if (!mat || !arr) {
                        System.out.println("Sakuma nepieciesams izveidot masivu un vektoru!");
                        continue;
                    }
                    C = insertion.insertionSort(B);
                    System.out.print("Massivs ir sakartots ar insertionSort:   ");
                    for (int i1 = 0; i1 < C.length; i1++) {
                        System.out.print(C[i1] + " ");
                    }
                    System.out.println();
                    break;
                // Izveelnes sestaa punkta realizaacija. Vektora sakaartosana izmantojot izveeli
                case 6:
                    if (!mat || !arr) {
                        System.out.println("Sakuma nepieciesams izveidot masivu un vektoru!");
                        continue;
                    }
                    D = selection.selectionSort(B);
                    System.out.print("Massivs ir sakartots ar selectionSort:   ");
                    for (int i1 = 0; i1 < D.length; i1++) {
                        System.out.print(D[i1] + " ");
                    }
                    System.out.println();
                    break;
                // Pabeigt progammas darbiibu
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Ievadita nepienemama vertiba.");
            }
        } while (!quit);
        in.close();
        System.out.println("Bye-bye!");
    }
}