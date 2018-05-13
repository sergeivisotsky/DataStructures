package Trees;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class HeapTest {

    private int maxSize = 15;
    private Heap heap = new Heap(maxSize);

    private void insertableElements() {
        var rd = new Random();
        for (int i = 1; i <= maxSize; i++) {
            heap.insert(rd.nextInt(99) + 1);
        }
    }

    @Test
    public void insertionTest() {
        insertableElements();
        assertEquals(15, heap.size());
    }

    @Test
    public void removalTest() {

    }

    @Test
    public void displayTest() {

    }
}