package Ld3_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {
    private LinkedQueue linkedQueue = new LinkedQueue();
    private int iterator = 10;

    @Test
    public void QueIsEmptyTest() {
        assertTrue(linkedQueue.isEmpty());
        assertEquals(0, linkedQueue.getSize());
    }

    @Test
    public void enQueueEmptyQueueTest() {
        for (int i = 0; i < iterator; i++) {
            linkedQueue.enQueue(i);
        }

        assertTrue(!linkedQueue.isEmpty());
        assertEquals(iterator, linkedQueue.getSize());
    }

    @Test
    public void enqueueThanDequeueTest() {
        int number = 80;
        linkedQueue.enQueue(number);
        assertEquals(number, linkedQueue.deQueue());
    }

    @Test
    public void enQueueAndOutputTest() {
        for (int i = 0; i < iterator; i++) {
            linkedQueue.enQueue(i);
        }

        linkedQueue.outputQueue();
    }

    @Test
    public void enqueueThanPeekTest() {
        int number = 90;
        linkedQueue.enQueue(number);
        int size = linkedQueue.getSize();
        assertEquals(number, linkedQueue.peek());
        assertEquals(size, linkedQueue.getSize());
    }

    @Test
    public void TenInAndThenTenOutTest() {
        for (int i = 0; i < iterator; i++) {
            linkedQueue.enQueue(i);
        }

        for (int i = 0; i < iterator; i++) {
            assertEquals(i, ((Integer) linkedQueue.deQueue()).intValue());
        }
    }

    @Test
    public void removingDownToEmpty() {
        int numberOfRemoves = (int) (Math.random() * 20 + 1);
        for (int i = 0; i < numberOfRemoves; i++) {
            linkedQueue.enQueue(80);
        }
        for (int i = 0; i < numberOfRemoves; i++) {
            linkedQueue.deQueue();
        }

        assertTrue(linkedQueue.isEmpty());
        assertEquals(0, linkedQueue.getSize());
    }

    @Test
    public void removingOnEmptyQueueTest() {
        assertTrue(linkedQueue.isEmpty());
        linkedQueue.deQueue();
    }

    @Test
    public void peekIntoEmptyQueueTest() {
        assertTrue(linkedQueue.isEmpty());
        linkedQueue.deQueue();
    }
}