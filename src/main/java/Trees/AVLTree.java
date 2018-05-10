package Trees;

interface IAVLTree {
    int getSize();

    boolean isEmpty();

    int getHeight(AVLTree.Node node);

    int maximum(int firstData, int secondData);

    AVLTree.Node leftRotate(AVLTree.Node x);

    AVLTree.Node rightRotate(AVLTree.Node y);

    int getBalance(AVLTree.Node node);

    void insert(int data);

    int find(int data);

    void delete(int data);

//    boolean isFull();
}

public class AVLTree implements IAVLTree {
    class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    Node root;
    private int size = 0;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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
    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }

    @Override
    public void insert(int data) {
        size++;
        root = insertionWrapper(root, data);
    }

    private Node insertionWrapper(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertionWrapper(node.left, data);
        } else if (data > node.data) {
            node.right = insertionWrapper(node.right, data);
        } else {
            return node;
        }

        node.height = 1 + maximum(getHeight(node.left),
                getHeight(node.right));

        int balance = getBalance(node);

        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        if (balance < -1 && data < node.right.data) {
            return leftRotate(node);
        }

        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    @Override
    public int find(int data) {
        return 0;
    }

    @Override
    public void delete(int data) {

    }

    void inOrderTraversal() {
        inOrderTraversalWrapper(root);
    }

    private void inOrderTraversalWrapper(Node root) {
        if (root != null) {
            if (isEmpty()) {
                throw new IllegalStateException("Tree is empty!");
            }

            inOrderTraversalWrapper(root.left);
            System.out.print(root.data + "\t");
            inOrderTraversalWrapper(root.right);
        } else {
            throw new NullPointerException("root = null");
        }
    }
}
