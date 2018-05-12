package Trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {
    private AVLTree AVLTree = new AVLTree();

    @Test
    public void isEmptyTest() {
        assertTrue(AVLTree.isEmpty());
        assertEquals(0, AVLTree.getSize());
    }

    @Test
    public void getHeightTest() {
        assertEquals(0, AVLTree.getHeight(AVLTree.root));
    }

    private void insertingElements() {
        AVLTree.insert(30);
        AVLTree.insert(50);
        AVLTree.insert(20);
        AVLTree.insert(45);
        AVLTree.insert(55);
        AVLTree.insert(60);
        AVLTree.insert(57);
        AVLTree.insert(70);
        AVLTree.insert(20);
        AVLTree.insert(10);
        AVLTree.insert(25);
    }

    @Test
    public void insertionTest() {
        AVLTree.insert(30);
        AVLTree.insert(15);
        AVLTree.insert(35);
        AVLTree.insert(22);
        AVLTree.insert(21);
        assertEquals(22, AVLTree.root.data);
        assertEquals(21, AVLTree.root.left.data);
        assertEquals(30, AVLTree.root.right.data);
        assertEquals(15, AVLTree.root.left.data);
        assertEquals(35, AVLTree.root.right.data);
        assertTrue(!AVLTree.isEmpty());
        assertEquals(5, AVLTree.getSize());
    }

    @Test
    public void oneLeftRotationTest() {
        AVLTree.insert(30);
        AVLTree.insert(40);
        AVLTree.insert(50);
    }

    @Test
    public void inOrderTraversalTest() {
        insertingElements();
        AVLTree.inOrderTraversal();
        assertTrue(!AVLTree.isEmpty());
        assertEquals(11, AVLTree.getSize());
    }
}