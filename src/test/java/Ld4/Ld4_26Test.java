package Ld4;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Ld4_26Test {
    private int maxSize = 15;

    private BSTInOrder bstInOrder = new BSTInOrder(maxSize);

    @Test
    public void emptyStatusTest() {
        assertTrue(bstInOrder.isEmpty());
        assertEquals(0, bstInOrder.getSize());
    }

    @Test
    public void isFullTest() {
        for (int i = 0; i < maxSize; i++) {
            bstInOrder.insert(i);
        }

        assertTrue(bstInOrder.isFull());
        assertEquals(maxSize, bstInOrder.getSize());
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
    public void insertElementsTest() {
        insertableElements();
        assertTrue(!bstInOrder.isEmpty());
        assertEquals(9, bstInOrder.getSize());
    }

    @Test
    public void insertAndInorderOutput() {
        insertableElements();
        bstInOrder.inOrderOutput();
        assertTrue(!bstInOrder.isEmpty());
        assertEquals(9, bstInOrder.getSize());
    }

    @Test
    public void countNodesWithRightChildrenTest() {
        insertableElements();
        assertEquals(2, bstInOrder.countNodesWithRightChildren());
    }

    @Test
    public void countNodesWithoutChildren() {
        insertableElements();
        assertEquals(4, bstInOrder.countNodesWithoutChildren());
    }

    @Test
    public void negativeElementQuantityTest() {
        bstInOrder.insert(21);
        bstInOrder.insert(-3);
        bstInOrder.insert(-5);
        assertEquals(2, bstInOrder.negativeElementQuantity());
    }
}