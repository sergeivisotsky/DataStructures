package QueuesStacks;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class LinkedStackTest {
    private LinkedStack stack = new LinkedStack(10);

    @Test
    public void isEmptyTest() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    private void pushableElements() {
        stack.push(90);
        stack.push(7);
        stack.push(3);
        stack.push(34);
        stack.push(4);
        stack.push(56);
        stack.push(7);
        stack.push(5);
        stack.push(78);
        stack.push(36);
    }

    @Test
    public void pushTest() {
        pushableElements();
        assertTrue(stack.isFull());
        assertEquals(10, stack.getSize());
        stack.displayStack();
    }

    @Test
    public void popTest() {
        pushableElements();
        System.out.println("Before: ");
        stack.displayStack();
        stack.pop();
        System.out.println("\nAfter: ");
        stack.displayStack();
        assertEquals(9, stack.getSize());
    }

    @Test
    public void peekTest() {
        pushableElements();
        assertEquals(36, stack.peek());
    }

    @Test
    public void intervalNumbersTest() {
        pushableElements();
        assertEquals(5, stack.intervalNumbers());
    }
}