package Ld3_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorQueueTest {
    protected VectorQueue queue = new VectorQueue(10);

    @Test
    public void testNewQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(queue.getSize(), 0);
    }

    @Test
    public void testInsertsToEmptyQueue() {
        int numberOfInserts = 6;
        for (int i = 0; i < numberOfInserts; i++) {
            queue.enQueue(40);
        }
        assertTrue(!queue.isEmpty());
        assertEquals(queue.getSize(), numberOfInserts);
    }

    @Test
    public void testEnqueueThenDequeue() {
        int number = 19;
        queue.enQueue(number);
        assertEquals(queue.deQueue(), number);
    }

    @Test
    public void testEnqueueThenPeek() {
        int number = 19;
        queue.enQueue(number);
        int size = queue.getSize();
        assertEquals(queue.peek(), number);
        assertEquals(queue.getSize(), size);
    }

    @Test
    public void testFiftyInThenFiftyOut() {
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(((Integer) queue.deQueue()).intValue(), i);
        }
    }

    @Test
    public void testRemovingDownToEmpty() {
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
    public void testRemoveOnEmptyQueue() {
        assertTrue(queue.isEmpty());
        queue.deQueue();
    }

    //    @Test(expected=NoSuchElementException.class)
    @Test
    public void testPeekIntoEmptyQueue() {
        assertTrue(queue.isEmpty());
        queue.deQueue();
    }
}