import java.util.List;

public class Student {
    private String name;
    private List<Byte> grades;

    public Student() {
    }

    public Student(String name, List<Byte> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Byte> getGrades() {
        return grades;
    }

    public void setGrades(List<Byte> grades) {
        this.grades = grades;
    }
}
