package LinkedLists;

import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SortedDoublyLinkedListTest {
    private int maxSize = 10;
    private SortedDoublyLinkedCircularList list =
            new SortedDoublyLinkedCircularList(maxSize);
    private int iterator = maxSize;

    @Test
    public void emptyStatusTest() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }

    @Test
    public void sortedInsertionAndOutputTest() {
        Random rd = new Random();
        for (int i = 0; i < iterator; i++) {
            list.insert(rd.nextInt(99) + 1);
        }

        list.display();
        assertTrue(!list.isEmpty());
        assertEquals(10, list.getSize());
    }

    private void insertionScope() {
        list.insert(20);
        list.insert(1);
        list.insert(18);
        list.insert(19);
        list.insert(56);
        list.insert(-1);
        list.insert(25);
        list.insert(3);
        list.insert(26);
        list.insert(52);
    }

    @Test
    public void removeAtPositionTest() {
        insertionScope();
        System.out.println("Before: ");
        list.display();
        list.deleteAtPosition(3);
        System.out.println("\nAfter: ");
        list.display();
    }

    @Test
    public void intervalNumber() {
        insertionScope();
        assertEquals(3, list.intervalNumbers());
    }
}