package Trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeapTest {

    private int maxSize = 11;
    private Heap heap = new Heap(maxSize);

    private void insertingElements() {
        heap.insert(25);
        heap.insert(99);
        heap.insert(12);
        heap.insert(90);
        heap.insert(93);
        heap.insert(80);
        heap.insert(102);
        heap.insert(95);
        heap.insert(34);
        heap.insert(74);
    }

    @Test
    public void insertionAndDisplayTest() {
        insertingElements();
        heap.display();
        assertTrue(!heap.isEmpty());
        assertEquals(10, heap.size());
    }

    @Test
    public void removalTest() {
        insertingElements();
        assertTrue(!heap.isEmpty());
        assertEquals(10, heap.size());
        System.out.println("Heap before: ");
        heap.display();
        System.out.println("\n");
        System.out.println("Removable element: " + heap.remove());
        System.out.println("\nHeap after: ");
        heap.display();
        assertEquals(9, heap.size());
    }
}