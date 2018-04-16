package Ld2_30;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortedDoublyLinkedListTest {
    private int maxSize = 10;
    private SortedDoublyLinkedList list =
            new SortedDoublyLinkedList(maxSize);
    private int iterator = maxSize;

    @Test
    void emptyStatusTest() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }
    @Test
    void sortedInsertionAndOutputTest() {
        Random rd = new Random();
        for (int i = 0; i < iterator; i++) {
            list.insert(rd.nextInt(9) + 1);
        }

        list.display();
        assertTrue(!list.isEmpty());
        assertEquals(10, list.getSize());
    }
}