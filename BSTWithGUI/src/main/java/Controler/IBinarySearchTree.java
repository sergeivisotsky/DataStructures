package Controler;

public interface IBinarySearchTree {
    void insert(int element);

    void postOrderOutput();

    int countNodesWithTwoChildren();

    int evenElementQuantity();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}