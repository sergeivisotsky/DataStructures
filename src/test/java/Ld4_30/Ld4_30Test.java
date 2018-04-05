package Ld4_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ld4_30Test {
    private BinarySearchTree tree = new BinarySearchTree();
    private int iterator = 15;

    @Test
    public void treeIsEmptyTest() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.getSize());
    }

    @Test
    public void insertElementTest() {
        for (int i = 0; i < iterator; i++) {
            tree.insert(iterator);
        }

        assertTrue(!tree.isEmpty());
        assertEquals(10, tree.getSize());
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