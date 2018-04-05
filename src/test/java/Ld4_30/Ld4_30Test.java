package Ld4_30;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class Ld4_30Test {
    private int iterator = 15;
    private BinarySearchTree tree = new BinarySearchTree(iterator);

    @Test
    public void treeIsEmptyTest() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.getSize());
    }

    @Test
    public void treeIsFullTest() {
        for (int i = 0; i < iterator; i++) {
            tree.insert(i);
        }

        assertTrue(tree.isFull());
        assertEquals(iterator, tree.getSize());
    }

    @Test
    public void insertElementTest() {
        for (int i = 0; i < iterator; i++) {
            tree.insert(iterator);
        }

        assertTrue(!tree.isEmpty());
        assertEquals(iterator, tree.getSize());
    }

    @Test
    public void insertAndOutputVertexesTest() {

    }

    @Test
    public void findTwoChildesTest() {

    }

    @Test
    public void EvenElementQuantity() {

    }
}