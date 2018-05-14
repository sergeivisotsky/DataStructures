package Trees;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class HeapTest {

    private int maxSize = 16;
    private Heap heap = new Heap(maxSize);

    private void insertingElements() {
        var rd = new Random();
        for (int i = 1; i <= maxSize; i++) {
            heap.insert(rd.nextInt(99) + 1);
        }
    }

    @Test
    public void insertionAndDisplayTest() {
        insertingElements();
        heap.display();
        assertTrue(!heap.isEmpty());
        assertEquals(15, heap.size());
    }

    @Test
    public void removalTest() {
        insertingElements();
        assertTrue(!heap.isEmpty());
        assertEquals(15, heap.size());
        System.out.println("Heap before: ");
        heap.display();
        heap.remove();
        System.out.println("\nHeap after: ");
        heap.display();
        assertEquals(14, heap.size());
    }
}