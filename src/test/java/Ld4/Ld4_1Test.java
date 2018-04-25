package Ld4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ld4_1Test {
    private int maxSize = 15;
    private BSTPreOrder tree = new BSTPreOrder(maxSize);

    @Test
    void isEmptyTest() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.getSize());
    }

    @Test
    void isFullTest() {
        for (int i = 0; i < maxSize; i++) {
            tree.insert(i);
        }

        assertTrue(tree.isFull());
        assertEquals(maxSize, tree.getSize());
    }

    private void insertableElements() {
        tree.insert(12);
        tree.insert(3);
        tree.insert(56);
        tree.insert(78);
        tree.insert(36);
        tree.insert(1);
        tree.insert(9);
    }

    /*
    *          12
    *         /  \
    *       /     \
    *      3      56
    *     / \    /  \
    *    1   9  36  78
    *
    **/

    @Test
    void insertElementsTest() {
        insertableElements();
        assertTrue(!tree.isFull());
        assertEquals(7, tree.getSize());
    }

    @Test
    void preOrderOutputTest() {
        insertableElements();
        tree.preOrderOutput();
        assertTrue(!tree.isEmpty());
    }

    @Test
    void countEmptyNodesTest() {
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        assertEquals(2, tree.countNodesWithoutChildren());
    }

    @Test
    void intervalNumbersTest() {
        tree.insert(-8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(12);
        assertEquals(3, tree.intervalNumberQuantity());
    }
}