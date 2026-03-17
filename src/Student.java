import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int age;

    // TODO: Task 1 — Создай конструктор, который принимает имя, GPA и возраст
    public Student(String name, double gpa, int age) {
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    // TODO: Task 1 — Добавь возможность изменить GPA
    public void setGpa(double newGpa) {
        gpa = newGpa;
    }

    // TODO: Task 1 (Sorting) — Реализуй Comparable по GPA (по возрастанию)
    @Override
    public int compareTo(Student other) {
        // заглушка — верни правильное значение сравнения
        return Double.compare(other.gpa, this.gpa);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + " GPA: " + gpa;
    }
}

