package Ld2_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList = new LinkedList();
    private int iterator = 10;

    @Test
    public void testThatListIsEmpty() {
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.getSize());
    }

    @Test
    public void testInsertionInEmptyList() {
        for (int i = 0; i < iterator; i++) {
            linkedList.insert(30);
        }
        assertTrue(!linkedList.isEmpty());
        assertEquals(iterator, linkedList.getSize());
    }

    @Test
    public void testNodeInsertionAndDeletion() {
        for (int i = 0; i < iterator; i++) {
            linkedList.insert(30);
        }
        linkedList.deleteNode(5);
        assertEquals(9, linkedList.getSize());
    }

    @Test
    public void testTenInsertAndThenDelete() {
        for (int i = 0; i < iterator; i++) {
            linkedList.insert(iterator);
        }

        for (int i = 0; i < iterator; i++) {
            linkedList.deleteNode(iterator);
        }

        assertEquals(0, linkedList.getSize());
    }

    @Test
    public void testEqualsToZero() {
        for (int i = 0; i < iterator; i++) {
            linkedList.insert(0);
        }

        assertEquals(10, linkedList.equalsToZero());
    }
}