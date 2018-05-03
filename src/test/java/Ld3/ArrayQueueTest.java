package Ld3;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ArrayQueueTest {
    private ArrayQueue queue = new ArrayQueue(10);
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

        queue.displayQueue();
    }

    @Test
    public void enQueueThenDequeueTest() {
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
    public void enQueueDequeueOutputTest() {
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