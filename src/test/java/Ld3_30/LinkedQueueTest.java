package Ld3_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedQueueTest {
    private LinkedQueue linkedQueue = new LinkedQueue();
    private int iterator = 10;

    @Test
    public void QueueIsEmptyTest() {
        assertTrue(linkedQueue.isEmpty());
        assertEquals(0, linkedQueue.getSize());
    }

    @Test
    public void enQueueAndOutputTest() {
        for (int i = 0; i < iterator; i++) {
            linkedQueue.enQueue(i);
        }

        linkedQueue.displayQueue();
        assertTrue(!linkedQueue.isEmpty());
        assertEquals(10, linkedQueue.getSize());
    }

    @Test
    public void enqueueThanDequeueTest() {
        for (int i = 0; i < iterator; i++) {
            linkedQueue.enQueue(i);
        }
        System.out.println("Before: ");
        linkedQueue.displayQueue();
        linkedQueue.deQueue();
        System.out.println("\nAfter: ");
        linkedQueue.displayQueue();
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
    public void removingDownToEmpty() {
        int numberOfRemoves = 10;
        for (int i = 0; i < numberOfRemoves; i++) {
            linkedQueue.enQueue(i);
        }
        for (int i = 0; i < numberOfRemoves; i++) {
            linkedQueue.deQueue();
        }

        assertTrue(linkedQueue.isEmpty());
        assertEquals(0, linkedQueue.getSize());
    }

    @Test
    public void negativeNumberQuantityTest() {
        int element = -1;
        for (int i = 0; i < iterator; i++) {
            linkedQueue.enQueue(element);
        }

        assertEquals(10, linkedQueue.negativeNumberQuantity());
    }
}