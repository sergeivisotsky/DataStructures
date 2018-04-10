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
        for (int i = 0; i < iterator; i++) {
            tree.insert(random.nextInt(99) + 1);
        }

        tree.postorderOutput();
        assertTrue(!tree.isEmpty());
        assertEquals(iterator, tree.getSize());
    }

    @Test
    void countNodesWithTwoChildrenTest() {
        tree.insert(20);
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(50);
        tree.insert(28);
        assertEquals(2, tree.countNodesWithTwoChildren());
    }

    /**
     *            20
     *        /       \
     *       10       50
     *     /   \     /
     *    5     15  25
     *             /
     *            28
     */

    @Test
    void evenElementQuantity() {
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(8);
        tree.evenElementQuantity();
        assertEquals(4, tree.evenElementQuantity());
    }
}