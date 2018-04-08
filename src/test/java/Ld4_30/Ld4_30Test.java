package Ld4_30;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ld4_30Test {
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
            tree.insert(i);
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
        Random rd = new Random();
        for (int i = 0; i < iterator; i++) {
            tree.insert(rd.nextInt(15));
        }

        tree.postorderOutput();
        assertTrue(!tree.isEmpty());
        assertEquals(iterator, tree.getSize());
    }

    @Test
    void findTwoChildesTest() {

    }

    @Test
    void EvenElementQuantity() {

    }
}