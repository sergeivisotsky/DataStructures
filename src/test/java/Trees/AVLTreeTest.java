package Trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {
    private AVLTreeClass AVLTree = new AVLTreeClass();

    @Test
    public void isEmptyTest() {
        assertTrue(AVLTree.isEmpty());
        assertEquals(0, AVLTree.getSize());
    }

    @Test
    public void heightCalculationTest() {
    }
}