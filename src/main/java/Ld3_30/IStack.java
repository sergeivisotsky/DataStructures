package Ld3_30;

public interface IStack {
    boolean isFull();

    int getSize();

    boolean isEmpty();

    void push(int element);

    void displayStack();

    void pop();

    int intervalNumbers();
}
