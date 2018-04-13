package Ld2_30;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    private DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    private int iterator = 10;
    private Random rd = new Random();

    @Test
    void isEmptyTest() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }

    @Test
    void insertionTest() {
        for (int i = 0; i < iterator; i++) {
            list.insert(rd.nextInt(29) + 1);
        }
        assertTrue(list.isFull());
        assertEquals(10, list.getSize());
    }

    @Test
    void displayTest() {
        for (int i = 0; i < iterator; i++) {
            list.insert(rd.nextInt(29) + 1);
        }

        list.display();
    }
}