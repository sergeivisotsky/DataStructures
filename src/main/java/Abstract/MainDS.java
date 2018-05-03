package Abstract;

import java.util.LinkedList;

class Student {
    private String name;
    private String surname;
    private int age;
    private String studentNumber;
    private String groupNumber;

    Student(String name, String surname, int age,
            String studentNumber, String groupNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.studentNumber = studentNumber;
        this.groupNumber = groupNumber;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    int getAge() {
        return age;
    }

    String getStudentNumber() {
        return studentNumber;
    }

    String getGroupNumber() {
        return groupNumber;
    }
}

public class MainDS {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();
        students.add(new Student("John", "Smith", 23, "171rdb042", "IRDBD13"));
        students.add(new Student("Lilia", "Quick", 19, "171rdb056", "IRDBD10"));
        students.add(new Student("Johanna", "Bloom", 20, "171rdb045", "IRDBD02"));
        for (Student student : students) {
            System.out.print(student.getName() + "\t\t");
            System.out.print(student.getSurname() + "\t\t");
            System.out.print(student.getAge() + "\t\t");
            System.out.print(student.getStudentNumber() + "\t\t");
            System.out.print(student.getGroupNumber() + "\t\t");
            System.out.println();
        }
    }
}
