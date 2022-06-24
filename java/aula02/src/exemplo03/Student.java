package exemplo03;

// HERANCA

public class Student extends Person {
    private String course;

    public Student(String name, String course) {
        super(name); // mesma coisa que Person(name);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + course;
    }
}
