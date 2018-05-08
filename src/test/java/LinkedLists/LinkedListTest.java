package LinkedLists;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList linkedList = new LinkedList();
    private int iterator = 10;

    @Test
    public void listIsEmptyTest() {
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.getSize());
    }

    @Test
    public void insertionInEmptyListTest() {
        for (int i = 0; i < iterator; i++) {
            linkedList.insert(30);
        }
        assertTrue(!linkedList.isEmpty());
        assertEquals(iterator, linkedList.getSize());
    }

    @Test
    public void nodeInsertionAndDeletionTest() {
        for (int i = 0; i < iterator; i++) {
            linkedList.insert(30);
        }
        linkedList.deleteNode(5);
        assertEquals(9, linkedList.getSize());
    }

    @Test
    public void tenInsertAndThenDeleteTest() {
        for (int i = 0; i < iterator; i++) {
            linkedList.insert(iterator);
        }

        for (int i = 0; i < iterator; i++) {
            linkedList.deleteNode(iterator);
        }

        assertEquals(0, linkedList.getSize());
    }

    @Test
    public void equalsToZeroTest() {
        for (int i = 0; i < iterator; i++) {
            linkedList.insert(0);
        }

        assertEquals(10, linkedList.equalsToZero());
    }
}