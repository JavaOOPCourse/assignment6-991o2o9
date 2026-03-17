import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2){
        if (st1.getGpa() > st2.getGpa()) return -1;
        else if (st1.getGpa() < st2.getGpa()) return 1;
        else {
            return st1.getName().compareTo(st2.getName());
        }
    }
}
