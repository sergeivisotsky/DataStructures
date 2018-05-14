package Trees;

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
    private int size = 0;

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
            return;
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
}
