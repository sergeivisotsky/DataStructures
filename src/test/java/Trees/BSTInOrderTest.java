package Trees;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class BSTInOrderTest {
    private int maxSize = 15;

    private BSTInOrderClass bstInOrderClass = new BSTInOrderClass(maxSize);

    @Test
    public void emptyStatusTest() {
        assertTrue(bstInOrderClass.isEmpty());
        assertEquals(0, bstInOrderClass.getSize());
    }

    @Test
    public void isFullTest() {
        for (int i = 0; i < maxSize; i++) {
            bstInOrderClass.insert(i);
        }

        assertTrue(bstInOrderClass.isFull());
        assertEquals(maxSize, bstInOrderClass.getSize());
    }

    private void insertableElements() {
        bstInOrderClass.insert(12);
        bstInOrderClass.insert(3);
        bstInOrderClass.insert(56);
        bstInOrderClass.insert(78);
        bstInOrderClass.insert(34);
        bstInOrderClass.insert(1);
        bstInOrderClass.insert(9);
        bstInOrderClass.insert(80);
        bstInOrderClass.insert(85);
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
        assertTrue(!bstInOrderClass.isEmpty());
        assertEquals(9, bstInOrderClass.getSize());
    }

    @Test
    public void insertAndInorderOutput() {
        insertableElements();
        bstInOrderClass.inOrderOutput();
        assertTrue(!bstInOrderClass.isEmpty());
        assertEquals(9, bstInOrderClass.getSize());
    }

    @Test
    public void countNodesWithRightChildrenTest() {
        insertableElements();
        assertEquals(2, bstInOrderClass.countNodesWithRightChildren());
    }

    @Test
    public void countNodesWithoutChildren() {
        insertableElements();
        assertEquals(4, bstInOrderClass.countNodesWithoutChildren());
    }

    @Test
    public void negativeElementQuantityTest() {
        bstInOrderClass.insert(21);
        bstInOrderClass.insert(-3);
        bstInOrderClass.insert(-5);
        assertEquals(2, bstInOrderClass.negativeElementQuantity());
    }
}