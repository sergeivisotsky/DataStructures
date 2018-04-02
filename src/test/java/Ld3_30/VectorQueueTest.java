package Ld3_30;

import org.junit.jupiter.api.Test;

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
    public void enqueueThenDequeueTest() {
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
    public void enqueueThenPeekTest() {
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
        int numberOfRemoves = (int) (Math.random() * 20 + 1);
        for (int i = 0; i < numberOfRemoves; i++) {
            queue.enQueue(19);
        }
        for (int i = 0; i < numberOfRemoves; i++) {
            queue.deQueue();
        }
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
    }

    //    @Test(expected=NoSuchElementException.class)
    @Test
    public void removeOnEmptyQueueTest() {
        assertTrue(queue.isEmpty());
        queue.deQueue();
    }

    //    @Test(expected=NoSuchElementException.class)
    @Test
    public void peekIntoEmptyQueueTest() {
        assertTrue(queue.isEmpty());
        queue.peek();
    }
}