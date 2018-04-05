package Ld3_30;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class VectorQueueTest {
    protected VectorQueue queue = new VectorQueue(10);
    private int iterator = 10;

    @Test
    public void newQueueIsEmptyTest() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
    }

    @Test
    public void insertsToEmptyQueueTest() {
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(i);
        }
        assertTrue(!queue.isEmpty());
        assertEquals(iterator, queue.getSize());
    }

    @Test
    public void enQueueAndOutput() {
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(i);
        }

        queue.outputQueue();
    }

    @Test
    public void enQueueThenDequeueTest() {
        int number = 0;
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(i);
        }
        queue.outputQueue();
        assertEquals(number, queue.deQueue());
        System.out.println();
        queue.outputQueue();
    }

    @Test
    public void enQueueThenPeekTest() {
        int number = 19;
        queue.enQueue(number);
        int size = queue.getSize();
        assertEquals(number, queue.peek());
        assertEquals(size, queue.getSize());
    }

    @Test
    public void tenInThenTenOutTest() {
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i, ((Integer) queue.deQueue()).intValue());
        }
    }

    @Test
    public void removingDownToEmptyTest() {
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
    public void removeOnEmptyQueueTest() {
        assertTrue(queue.isEmpty());
        queue.deQueue();
    }

    @Test
    public void peekIntoEmptyQueueTest() {
        assertTrue(queue.isEmpty());
        queue.peek();
    }

    @Test
    public void negativeElementQuantityTest() {
        int element = -1;
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(element);
        }
        assertEquals(10, queue.negativeNumberQuantity());
    }
}