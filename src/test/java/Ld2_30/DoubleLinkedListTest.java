package Ld2_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    DoubleLinkedList linkedList = new DoubleLinkedList();

    @Test
    void isEmptyTest() {
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.getSize());
    }

}