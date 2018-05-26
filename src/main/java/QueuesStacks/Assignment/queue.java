package QueuesStacks.Assignment;

class CompQ {
    int item;
    CompQ next;

    CompQ(int s) {
        item = s;
        next = null;
    }
}

public class queue {
    private CompQ pBegin;
    private CompQ pEnd;
    private int size;
    private queue() {
        pBegin = null;
        pEnd = null;
        size = 0;
    }

    private void enQueue(int c) {
        CompQ temp = new CompQ(c);
        if (pBegin == null) {
            pBegin = temp;
            pEnd = temp;
        } else {
            pEnd.next = temp;
            pEnd = temp;
        }
        size++;
    }

    private int deQueue() {
        int c = pBegin.item;
        pBegin = pBegin.next;
        size--;
        return c;
    }

    public static void main(String[] args) {
        queue queue = new queue();
        for (int i = 20; i >= 1; i -= 2) {
            queue.enQueue(i);
        }
        int c = queue.deQueue();
        System.out.println(c + queue.size);
    }
}
