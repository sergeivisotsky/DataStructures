package Ld3;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class deQueTest {

    private int maxSize = 10;
    private DoubleEndedQueue deQue = new DoubleEndedQueue(maxSize);

    @Test
    public void isEmptyTest() {
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
    public void isFullTest() {
        insertableElements();
        assertTrue(deQue.isFull());
        assertEquals(10, deQue.getSize());
    }

    @Test
    public void insertFirstTest() {
        for (int i = 1; i <= 28; i += 3) {
            deQue.insertFirst(i);
        }
        deQue.display();
        assertTrue(!deQue.isEmpty());
        assertEquals(10, deQue.getSize());
    }

    @Test
    public void insertLastTest() {
        for (int i = 1; i <= 25; i += 3) {
            deQue.insertFirst(i);
        }
        deQue.insertLast(3);
        deQue.display();
        assertTrue(!deQue.isEmpty());
        assertEquals(10, deQue.getSize());
    }

    @Test
    public void deQueFirstTest() {
        insertableElements();
        System.out.println("Before: ");
        deQue.display();
        System.out.println("\nAfter: ");
        assertEquals(13, deQue.deQueueFirst());
        deQue.display();
    }

    @Test
    public void deQueLastTest() {
        insertableElements();
        System.out.println("Before: ");
        deQue.display();
        System.out.println("\nAfter: ");
        assertEquals(13, deQue.deQueueLast());
        deQue.display();
    }

    @Test
    public void peekFirstTest() {
        insertableElements();
        assertEquals(13, deQue.peekFirst());
    }

    @Test
    public void peekLastTest() {
        insertableElements();
        assertEquals(13, deQue.peekLast());
    }
}