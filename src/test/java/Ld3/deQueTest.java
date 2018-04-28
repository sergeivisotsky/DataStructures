package Ld3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class deQueTest {

    private int maxSize = 10;
    private deQue deQue = new deQue(maxSize);

    @Test
    void isEmptyTest() {
        assertTrue(deQue.isEmpty());
        assertEquals(0, deQue.getSize());
    }

    @Test
    void insertFirstTest() {
        for (int i = 1; i <= 28; i += 3) {
            deQue.insertFirst(i);
        }
        deQue.display();
        assertTrue(!deQue.isEmpty());
        assertEquals(10, deQue.getSize());
    }

    @Test
    void insertLastTest() {
//        deQue.insertLast(44);
        for (int i = 1; i <= 28; i += 3) {
            deQue.insertFirst(i);
        }
        deQue.insertLast(3);
        deQue.display();
        assertTrue(!deQue.isEmpty());
        assertEquals(11, deQue.getSize());
    }
}