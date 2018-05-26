package QueuesStacks.Assignment;

class Comp {
    int info;
    Comp next;
}

public class Stack {
    private Comp top;
    private int size = 0;

    private void push(int e) {
        Comp t = new Comp();
        t.info = e;
        t.next = top;
        top = t;
        size++;
    }

    private int pop() {
        int i = top.info;
        top = top.next;
        size--;
        return i;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.top = null;
        for (int i = 3; i < 20; i += 3) {
            stack.push(i);
        }
        int info;
        info = stack.pop();
        System.out.println(info + stack.size);
    }
}
