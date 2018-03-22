package Abstract;

abstract class StudentLife {
    abstract void working();
    abstract void going();
    abstract void relaxing();
}

public class MainObjectTwo extends StudentLife {

    @Override
    void working() {
        System.out.println("Student is working too hard doing math!");
    }

    @Override
    void going() {
        System.out.println("Student is going to the gym!");
    }

    @Override
    void relaxing() {
        System.out.println("Student is watching movie in the cinema!");
    }
}
