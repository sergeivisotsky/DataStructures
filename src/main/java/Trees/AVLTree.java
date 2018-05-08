package Trees;

interface IAVLTree {

    int getHeight(AVLTreeClass.Node node);

    int maximum(int firstData, int secondData);

    AVLTreeClass.Node leftRotate(AVLTreeClass.Node x);

    AVLTreeClass.Node rightRotate(AVLTreeClass.Node y);

    void insert(int data);

    int find(int data);

    void delete(int data);

    int getSize();

    boolean isEmpty();

//    boolean isFull();
}

class AVLTreeClass implements IAVLTree {
    class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    private Node root;
    private int size = 0;

    @Override
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    @Override
    public int maximum(int firstData, int secondData) {
        return (firstData > secondData)
                ? firstData : secondData;
    }

    @Override
    public Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        x.left = x;
        x.right = T2;

        x.height = maximum(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = maximum(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    @Override
    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = maximum(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = maximum(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    @Override
    public void insert(int data) {

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
