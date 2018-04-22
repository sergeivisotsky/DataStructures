package Ld3_30.Test;

class CompQ {
    int item;
    CompQ next;

    public CompQ(int s) {
        item = s;
        next = null;
    }
}

public class queue {
    private CompQ pBegin;
    private CompQ pEnd;
    private int size;
    public queue() {
        pBegin = null;
        pEnd = null;
        size = 0;
    }

    public void addQueue(int c) {
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

    public int delQueue() {
        int c = pBegin.item;
        pBegin = pBegin.next;
        size--;
        return c;
    }

    public static void main(String[] args) {
        queue queue = new queue();
        for (int i = 20; i >= 1; i -= 2) {
            queue.addQueue(i);
        }
        int c = queue.delQueue();
        System.out.println(c + queue.size);
    }
}
