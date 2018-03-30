package Abstract;

interface IStudentState {
    void working();
    void going();
    void relaxing();
}

public class MainObject implements IStudentState {
    @Override
    public void working() {
        System.out.println("Student is working too hard doing math!");;
    }

    @Override
    public void going() {
        System.out.println("Student is going to the gym!");
    }

    @Override
    public void relaxing() {
        System.out.println("Student is watching movie in the cinema!");
    }
}
