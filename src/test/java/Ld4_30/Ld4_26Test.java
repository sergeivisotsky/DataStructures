package Ld4_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ld4_26Test {
    private Ld4_26 bstInOrder = new Ld4_26(15);

    @Test
    void emptyStatusTest() {
        assertTrue(bstInOrder.isEmpty());
        assertEquals(0, bstInOrder.getSize());
    }

    @Test
    void isFullTest() {
        for (int i = 0; i < 15; i++) {
            bstInOrder.insert(i);
        }

        assertTrue(bstInOrder.isFull());
        assertEquals(15, bstInOrder.getSize());
    }

    private void insertableElements() {
        bstInOrder.insert(12);
        bstInOrder.insert(3);
        bstInOrder.insert(56);
        bstInOrder.insert(78);
        bstInOrder.insert(34);
        bstInOrder.insert(1);
        bstInOrder.insert(9);
        bstInOrder.insert(80);
        bstInOrder.insert(85);
    }

    /*
    *           12
    *         /   \
    *        /     \
    *       3      56
    *      / \    /  \
    *     1   9  34  78
    *                  \
    *                  80
    *                   \
    *                   85
    */

    @Test
    void insertElementsTest() {
        insertableElements();
        assertTrue(!bstInOrder.isEmpty());
        assertEquals(9, bstInOrder.getSize());
    }

    @Test
    void insertAndInorderOutput() {
        insertableElements();
        bstInOrder.inorderOutput();
        assertTrue(!bstInOrder.isEmpty());
        assertEquals(9, bstInOrder.getSize());
    }

    @Test
    void countNodesWithRightChildrenTest() {
        insertableElements();
        assertEquals(2, bstInOrder.countNodesWithRightChildren());
    }

    @Test
    void negativeElementQuantityTest() {
        bstInOrder.insert(21);
        bstInOrder.insert(-3);
        bstInOrder.insert(-5);
        assertEquals(2, bstInOrder.negativeElementQuantity());
    }
}