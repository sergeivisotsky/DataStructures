package Trees;

interface IAVLTree {
    void insert(int data);

    AVLTreeClass.Node leftRotate(int data);
    AVLTreeClass.Node rightRotate(int data);

    int find(int data);

    void delete(int data);

    int getSize();

    boolean isEmpty();

//    boolean isFull();
}

class AVLTreeClass implements IAVLTree {
    class Node {
        int data;
        int height;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    private Node root;
    private int size = 0;

    @Override
    public void insert(int data) {

    }

    @Override
    public Node leftRotate(int data) {
        return null;
    }

    @Override
    public Node rightRotate(int data) {
        return null;
    }

    @Override
    public int find(int data) {
        return 0;
    }

    @Override
    public void delete(int data) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


}

public class AVLTree {
    public static void main(String[] args) {

    }
}
