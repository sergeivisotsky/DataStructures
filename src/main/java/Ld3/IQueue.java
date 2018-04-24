package Ld3;

public interface IQueue {
    boolean isFull();

    int getSize();

    boolean isEmpty();

    void enQueue(Object element);

    Object deQueue();

    void displayQueue();

    Object peek();
}
