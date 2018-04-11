package Ld4_30;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ld4_30Test {
    private Random random = new Random();
    private int iterator = 15;
    private BinarySearchTree tree = new BinarySearchTree(iterator);

    @Test
    void treeIsEmptyTest() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.getSize());
    }

    @Test
    void treeIsFullTest() {
        for (int i = 0; i < iterator; i++) {
            tree.insert(random.nextInt(99) + 1);
        }

        assertTrue(tree.isFull());
        assertEquals(iterator, tree.getSize());
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

    @Test
    void insertElementTest() {
        for (int i = 0; i < iterator; i++) {
            tree.insert(iterator);
        }

        assertTrue(!tree.isEmpty());
        assertEquals(iterator, tree.getSize());
    }

    @Test
    void createTreeAndPostorderOutputTest() {
        insertableElements();
        tree.postorderOutput();
        assertTrue(!tree.isEmpty());
        assertEquals(8, tree.getSize());
    }

    @Test
    void countNodesWithTwoChildrenTest() {
        insertableElements();
        assertEquals(3, tree.countNodesWithTwoChildren());
    }

    /**
     *          20
     *       /     \
     *     /        \
     *    10         30
     *  /   \       /  \
     * 5     15   25    50
     *                 /
     *                28
     */

    @Test
    void evenElementQuantity() {
        insertableElements();
        tree.evenElementQuantity();
        assertEquals(5, tree.evenElementQuantity());
    }
}