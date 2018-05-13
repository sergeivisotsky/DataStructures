package Trees;

interface IHeap {
    boolean isEmpty();

    int size();

    void insert(int data);

    void remove();

    void display();
}

public class Heap implements IHeap {

    private int[] heapArray;
    private int maxSize;
    private int size = 0;

    public Heap(int maxSize) {
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
        size++;
    }

    @Override
    public void remove() {

    }

    @Override
    public void display() {

    }
}
