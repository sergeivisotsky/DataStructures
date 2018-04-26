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




}