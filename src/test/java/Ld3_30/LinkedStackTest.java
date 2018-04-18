package Ld3_30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    private LinkedStack stack = new LinkedStack(10);

    @Test
    void isEmptyTest() {
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
    void pushTest() {
        pushableElements();
        assertTrue(stack.isFull());
        assertEquals(10, stack.getSize());
        stack.displayStack();
    }

    @Test
    void popTest() {
        pushableElements();
        System.out.println("Before: ");
        stack.displayStack();
        stack.pop();
        System.out.println("\nAfter: ");
        stack.displayStack();
        assertEquals(9, stack.getSize());
    }

    @Test
    void peekTest() {
        pushableElements();
        assertEquals(36, stack.peek());
    }

    @Test
    void intervalNumbersTest() {
        pushableElements();
        assertEquals(5, stack.intervalNumbers());
    }
}