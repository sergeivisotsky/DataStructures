package ObjectsAndDataStructures.JavaCode;

interface IStudentState {
    void working();

    void going();

    void relaxing();
}

public class MainObject {
    public static void main(String[] args) {
        IStudentState student = new IStudentState() {
            @Override
            public void working() {
                System.out.println("Student is working");
            }

            @Override
            public void going() {
                System.out.println("Student is going somewhere");
            }

            @Override
            public void relaxing() {
                System.out.println("Student is relaxing");
            }
        };

        student.working();
        student.going();
        student.relaxing();
    }
}