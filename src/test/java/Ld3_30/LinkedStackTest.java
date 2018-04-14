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

    @Test
    void pushTest() {
        stack.push(90);
        stack.push(7);
        stack.push(3);
        stack.push(34);
        stack.push(4);
        stack.push(56);
        stack.push(7);


    }
}