package ObjectsAndDataStructures.JavaCode;

abstract class StudentLife {
    abstract void working();

    abstract void going();

    abstract void relaxing();
}

public class MainObjectTwo {
    public static void main(String[] args) {
        StudentLife student = new StudentLife() {
            @Override
            void working() {
                System.out.println("Student is working");
            }

            @Override
            void going() {
                System.out.println("Student is going somewhere");
            }

            @Override
            void relaxing() {
                System.out.println("Student is relaxing");
            }
        };

        student.working();
        student.going();
        student.relaxing();
    }
}
