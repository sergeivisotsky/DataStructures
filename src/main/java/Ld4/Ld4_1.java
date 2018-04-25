package Ld4;

interface IBinarySearchTreeThree {
    void insert(int element);

    void preorderOutput();

    int countNodesWithoutChildren();

    int intervalNumberQuantity();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}

class BSTPreOrder implements IBinarySearchTreeThree {
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
    private int maxSize;

    public BSTPreOrder(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void insert(int element) {
        root = insertWrapper(root, element);
        size++;
    }

    private Node insertWrapper(Node node, int element) {
        if (node == null) {
            return new Node(element);
        }

        Node newSubtree;
        if (element < node.data) {
            newSubtree = insertWrapper(node.left, element);
            node.left = newSubtree;
            return node;
        } else if (element > node.data) {
            newSubtree = insertWrapper(node.right, element);
            node.right = newSubtree;
            return node;
        }

        return node;
    }

    @Override
    public void preorderOutput() {

    }

    private void preorderOutoutWrapper() {

    }

    @Override
    public int countNodesWithoutChildren() {
        return 0;
    }

    private void countNodesWithoutChildrenWrapper() {

    }

    @Override
    public int intervalNumberQuantity() {
        return 0;
    }

    private void intervalNumberQuantityWrapper() {

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
        return size == maxSize;
    }
}

public class Ld4_1 {
}
