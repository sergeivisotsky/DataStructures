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
        for (int i = 0; i < iterator; i++) {
            tree.insert(random.nextInt(50));
        }
        tree.countNodesWithTwoChildren();
    }

    @Test
    void evenElementQuantity() {
        for (int i = 0; i < iterator; i++) {
            tree.insert(random.nextInt(50));
        }
        tree.evenElementQuantity();
    }
}