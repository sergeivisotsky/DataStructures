package Ld2;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    private DoublyLinkedList list = new DoublyLinkedList();
    private int iterator = 10;
    private Random rd = new Random();

    @Test
    void isEmptyTest() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }

    @Test
    void insertAtBeginningTest() {
        for (int i = 0; i < iterator; i++) {
            list.insertFirst(rd.nextInt(29) + 1);
        }
        list.display();
        assertTrue(list.isFull());
        assertEquals(10, list.getSize());
    }

    @Test
    void insertAtPositionTest() {
        list.insertFirst(12);
        list.insertAtPosition(5, 1);
        list.display();
    }

    @Test
    void insertAtTheEndTest() {
        list.insertFirst(12);
        list.insertAtPosition(5, 1);
        list.insertLast(56);
        list.display();
    }

    @Test
    void insertAndDisplayTest() {
        for (int i = 0; i < iterator; i++) {
            list.insertFirst(rd.nextInt(29) + 1);
        }

        list.display();
    }

    @Test
    void deleteAndDisplayTest() {
        list.insertFirst(36);
        for (int i = 1; i < 3; i++) {
            list.insertAtPosition(i, i);
        }
        list.insertLast(46);
        System.out.println("Before deletion: ");
        list.display();

        list.deleteAtPosition(2);
        System.out.println("\n" + "After deletion:");
        list.display();
    }

    @Test
    void negativeElementQuantityTest() {
        list.insertFirst(36);
        for (int i = 1; i <= 3; i++) {
            list.insertAtPosition(-3, i);
        }
        list.insertLast(46);

        assertEquals(3, list.negativeElementQuantity());
    }
}