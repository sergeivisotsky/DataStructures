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
            list.insertAtBeginning(rd.nextInt(29) + 1);
        }
        list.display();
        assertTrue(list.isFull());
        assertEquals(10, list.getSize());
    }

    @Test
    void insertAtPositionTest() {
        list.insertAtBeginning(12);
        list.insertAtPosition(5, 1);
        list.display();
    }

    @Test
    void insertAtTheEndTest() {
        list.insertAtBeginning(12);
        list.insertAtPosition(5, 1);
        list.insertAtEnd(56);
        list.display();
    }

    @Test
    void insertAndDisplayTest() {
        for (int i = 0; i < iterator; i++) {
            list.insertAtBeginning(rd.nextInt(29) + 1);
        }

        list.display();
    }

    @Test
    void deleteAndDisplayTest() {
        list.insertAtBeginning(36);
        for (int i = 1; i < 3; i++) {
            list.insertAtPosition(i, i);
        }
        list.insertAtEnd(46);
        System.out.println("Before deletion: ");
        list.display();

        list.deleteAtPosition(2);
        System.out.println("\n" + "After deletion:");
        list.display();
    }

    @Test
    void negativeElementQuantityTest() {
        list.insertAtBeginning(36);
        for (int i = 1; i <= 3; i++) {
            list.insertAtPosition(-3, i);
        }
        list.insertAtEnd(46);

        assertEquals(3, list.negativeElementQuantity());
    }
}