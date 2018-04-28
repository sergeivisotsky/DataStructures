package Ld3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class deQueTest {

    private int maxSize = 10;
    private DoubleEndedQueue deQue = new DoubleEndedQueue(maxSize);

    @Test
    void isEmptyTest() {
        assertTrue(deQue.isEmpty());
        assertEquals(0, deQue.getSize());
    }

    private void insertableElements() {
        for (int i = 1; i <= 13; i += 3) {
            deQue.insertFirst(i);
        }
        for (int i = 1; i <= 13; i += 3) {
            deQue.insertLast(i);
        }
    }

    @Test
    void isFullTest() {
        insertableElements();
        assertTrue(deQue.isFull());
        assertEquals(10, deQue.getSize());
    }

    @Test
    void insertFirstTest() {
        for (int i = 1; i <= 28; i += 3) {
            deQue.insertFirst(i);
        }
        deQue.display();
        assertTrue(!deQue.isEmpty());
        assertEquals(10, deQue.getSize());
    }

    @Test
    void insertLastTest() {
        for (int i = 1; i <= 25; i += 3) {
            deQue.insertFirst(i);
        }
        deQue.insertLast(3);
        deQue.display();
        assertTrue(!deQue.isEmpty());
        assertEquals(10, deQue.getSize());
    }

    @Test
    void deQueFirstTest() {
        insertableElements();
        System.out.println("Before: ");
        deQue.display();
        System.out.println("\nAfter: ");
        assertEquals(13, deQue.deQueueFirst());
        deQue.display();
    }

    @Test
    void deQueLastTest() {
        insertableElements();
        System.out.println("Before: ");
        deQue.display();
        System.out.println("\nAfter: ");
        assertEquals(13, deQue.deQueueLast());
        deQue.display();
    }

    @Test
    void peekFirstTest() {
        insertableElements();
        assertEquals(13, deQue.peekFirst());
    }

    @Test
    void peekLastTest() {
        insertableElements();
        assertEquals(13, deQue.peekLast());
    }
}