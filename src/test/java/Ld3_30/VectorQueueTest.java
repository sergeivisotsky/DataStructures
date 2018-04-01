package Ld3_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorQueueTest {
    protected VectorQueue queue = new VectorQueue(10);
    private int iterator = 10;

    @Test
    public void newQueueIsEmptyTest() {
        assertTrue(queue.isEmpty());
        assertEquals(queue.getSize(), 0);
    }

    @Test
    public void insertsToEmptyQueueTest() {
        for (int i = 0; i < iterator; i++) {
            queue.enQueue(i);
        }
        assertTrue(!queue.isEmpty());
        assertEquals(queue.getSize(), iterator);
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
        int number = 19;
        queue.enQueue(number);
        assertEquals(queue.deQueue(), number);
    }

    @Test
    public void enqueueThenPeekTest() {
        int number = 19;
        queue.enQueue(number);
        int size = queue.getSize();
        assertEquals(queue.peek(), number);
        assertEquals(queue.getSize(), size);
    }

    @Test
    public void tenInThenTenOutTest() {
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(((Integer) queue.deQueue()).intValue(), i);
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
        assertEquals(queue.getSize(), 0);
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
        queue.deQueue();
    }
}