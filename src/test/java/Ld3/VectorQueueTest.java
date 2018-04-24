package Ld3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorQueueTest {
    private VectorQueue queue = new VectorQueue(10);
    private int iterator = 10;

    @Test
    void newQueueIsEmptyTest() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
    }

    @Test
    void insertsToEmptyQueueTest() {
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(i);
        }
        assertTrue(!queue.isEmpty());
        assertEquals(iterator, queue.getSize());
    }

    @Test
    void enQueueAndOutput() {
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(i);
        }

        queue.displayQueue();
    }

    @Test
    void enQueueThenDequeueTest() {
        int number = 0;
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(i);
        }
        queue.displayQueue();
        assertEquals(number, queue.deQueue());
        System.out.println();
        queue.displayQueue();
    }

    @Test
    void enQueueThenPeekTest() {
        int number = 19;
        queue.enQueue(number);
        int size = queue.getSize();
        assertEquals(number, queue.peek());
        assertEquals(size, queue.getSize());
    }

    @Test
    void tenInThenTenOutTest() {
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i, ((Integer) queue.deQueue()).intValue());
        }
    }

    @Test
    void removingDownToEmptyTest() {
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(i);
        }
        for (int i = 0; i < iterator; i++) {
            queue.deQueue();
        }
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
    }

    @Test
    void enQueueDequeueOutputTest() {
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(i);
        }
        System.out.println("Before: ");
        queue.displayQueue();
        queue.deQueue();
        System.out.println("\nAfter: ");
        queue.displayQueue();
    }

    @Test
    void peekIntoEmptyQueueTest() {
        assertTrue(queue.isEmpty());
        queue.peek();
    }

    @Test
    void negativeElementQuantityTest() {
        int element = -1;
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(element);
        }
        assertEquals(10, queue.negativeNumberQuantity());
    }
}