package Ld4_30;

interface IBinarySearchTreeTwo {
    void insert(int element);

    void inorderOutput();

    int countNodesWithTwoChildren();

    int zeroElementQuantity();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}

public class BSTInOrder implements IBinarySearchTreeTwo {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    @Override
    public void insert(int element) {

    }

    @Override
    public void inorderOutput() {

    }

    @Override
    public int countNodesWithTwoChildren() {
        return 0;
    }

    @Override
    public int zeroElementQuantity() {
        return 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == 15;
    }


}
