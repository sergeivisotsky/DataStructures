package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface IHeap {
    boolean isEmpty();

    int size();

    void insert(int data);

    int remove();

    void display();
}

public class Heap implements IHeap {

    private int[] heapArray;
    private int maxSize;
    private int size;

    Heap(int maxSize) {
        this.maxSize = maxSize;
        heapArray = new int[maxSize];
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(int data) {
        if ((size + 1) == maxSize) {
            System.out.println("Heap is full!");
        }

        heapArray[++size] = data;
        int position = size;
        while (position != 1 &&
                data > heapArray[position / 2]) {
            heapArray[position] = heapArray[position / 2];
            position /= 2;
        }
        heapArray[position] = data;
    }

    @Override
    public int remove() {
        int parent = 1;
        int child = 1;
        int data, temp;
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty!");
        }
        data = heapArray[1];
        temp = heapArray[size--];
        while (child <= size) {
            if (child < size &&
                    heapArray[child] < heapArray[child + 1]) {
                child++;
            }
            if (temp >= heapArray[child]) {
                break;
            }
            heapArray[parent] = heapArray[child];
            parent = child;
            child *= 2;
        }
        heapArray[parent] = temp;
        return data;
    }

    @Override
    public void display() {
        for (int i = 1; i < size - 1; i++) {
            System.out.print(heapArray[i] + "\t");
        }
    }

    public static void main(String[] args) {
        try (var reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            System.out.print("Heap maxSize: ");
            int maxSize = Integer.parseInt(reader.readLine());
            Heap heap = new Heap(maxSize);
            String yesNoAnswer;
            int answer;
            int element;
            do {
                System.out.println("1: Insert");
                System.out.println("2: remove");
                System.out.print("\nAnswer: ");
                answer = Integer.parseInt(reader.readLine());
                switch (answer) {
                    case 1:
                        System.out.print("Element: ");
                        element = Integer.parseInt(reader.readLine());
                        heap.insert(element);
                        break;
                    case 2:
                        System.out.println("Removable element: " + heap.remove());
                        break;
                    default:
                        throw new RuntimeException("No such a choice");
                }
                System.out.println("Created heap: ");
                heap.display();
                System.out.print("Continue(y/n)? ");
                yesNoAnswer = reader.readLine();
            } while (yesNoAnswer.equals("y") || yesNoAnswer.equals("Y"));
        } catch (IOException e) {
            System.out.println("Input-output error!");
        }
    }
}
