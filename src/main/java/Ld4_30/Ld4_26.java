package Ld4_30;

interface IBinarySearchTreeTwo {
    void insert(int element);

    void inorderOutput();

    int countNodesWithRightChildren();

    int negativeElementQuantity();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}

public class Ld4_26 implements IBinarySearchTreeTwo {
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
    public void inorderOutput() {
        inorderOutputWrapper(root);
    }

    private void inorderOutputWrapper(Node root) {
        if (root != null) {
            if (isEmpty()) {
                throw new IllegalStateException("Tree is empty!");
            }

            inorderOutputWrapper(root.left);
            System.out.print(root.data + "\t");
            inorderOutputWrapper(root.right);
        }
    }

    @Override
    public int countNodesWithRightChildren() {
        return countNodesWithRightChildrenWrapper(root);
    }

    private int countNodesWithRightChildrenWrapper(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right != null) {
            return countNodesWithRightChildrenWrapper(root.right);
        }
        
        return countNodesWithRightChildrenWrapper(root.right);
    }

    @Override
    public int negativeElementQuantity() {
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