package Abstract;

/**
 * Data structure example
 */
class Student {
    private String name;
    private String surname;
    private int age;
    private String studentNumber;
    private String groupNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
}

public class MainDS {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");
        student.setSurname("Kensington");
        student.setAge(19);
        student.setStudentNumber("111rdb111");
        student.setGroupNumber("IRDBD00");
    }
}
