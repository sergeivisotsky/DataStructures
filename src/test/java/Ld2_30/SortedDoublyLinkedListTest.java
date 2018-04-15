package Ld2_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedDoublyLinkedListTest {

    private SortedDoublyLinkedList list =
            new SortedDoublyLinkedList(10);

    @Test
    void emptyStatusTest() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }
}