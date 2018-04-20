package Ld4_30;

public interface IBinarySearchTree {
    void insert(int element);

    void postorderOutput();

    int countNodesWithTwoChildren();

    int evenElementQuantity();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}