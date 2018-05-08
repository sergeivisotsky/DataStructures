package Trees;

import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Ld4_30Test {
    private Random random = new Random();
    private int maxSize = 15;
    private BinarySearchTree tree = new BinarySearchTree(maxSize);

    @Test
    public void treeIsEmptyTest() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.getSize());
    }

    @Test
    public void treeIsFullTest() {
        for (int i = 0; i < maxSize; i++) {
            tree.insert(random.nextInt(99) + 1);
        }

        assertTrue(tree.isFull());
        assertEquals(maxSize, tree.getSize());
    }

    private void insertableElements() {
        tree.insert(20);
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(30);
        tree.insert(25);
        tree.insert(50);
        tree.insert(28);
    }

    /**
     * 20
     * /     \
     * /        \
     * 10         30
     * /   \       /  \
     * 5     15   25    50
     * /
     * 28
     */

    @Test
    public void insertElementTest() {
        for (int i = 0; i < maxSize; i++) {
            tree.insert(maxSize);
        }

        assertTrue(!tree.isEmpty());
        assertEquals(maxSize, tree.getSize());
    }

    @Test
    public void createTreeAndPostorderOutputTest() {
        insertableElements();
        tree.postOrderOutput();
        assertTrue(!tree.isEmpty());
        assertEquals(8, tree.getSize());
    }

    @Test
    public void countNodesWithTwoChildrenTest() {
        insertableElements();
        assertEquals(3, tree.countNodesWithTwoChildren());
    }

    @Test
    public void evenElementQuantity() {
        insertableElements();
        tree.evenElementQuantity();
        assertEquals(5, tree.evenElementQuantity());
    }
}