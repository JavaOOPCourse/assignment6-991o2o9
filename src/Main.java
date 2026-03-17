import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        Student stud1 = new Student("Amin",4.00,18);
        Student stud10 = new Student("Ainazik",4.00,18);
        Student stud2 = new Student("Alex",3.40,19);
        Student stud3 = new Student("Emir",4.00,17);
        Student stud4 = new Student("Alina",3.80,18);
        Student stud5 = new Student("Roma",3.90,19);

        students.put("ID12026", stud1);
        students.put("ID22026", stud2);
        students.put("ID32026", stud3);
        students.put("ID42026", stud4);
        students.put("ID52026", stud5);
        students.put("ID102026", stud10);


        // TODO: Напечатай всех студентов (ID + объект)
        for (Map.Entry<String, Student> entry : students.entrySet()){
            Student s = entry.getValue();
            System.out.println("ID: " + entry.getKey() + ", " + s);
        }

        // TODO: Найди студента по ID и выведи его
        String idForSearch = "ID32026";
        Student foundByID = students.get(idForSearch);
        System.out.println("\nStudent found by id: " + idForSearch + " -> " + foundByID);

        // TODO: Удали одного студента по ID
        System.out.println("\nDelete by id: " + idForSearch);
        Student std1 = students.remove(idForSearch);
        System.out.println("Student "+ std1.getName() + " was deleted");
        for (Map.Entry<String, Student> entry : students.entrySet()){
            Student s = entry.getValue();
            System.out.println("ID: " + entry.getKey() + ", " + s);
        }

        // TODO: Обнови GPA у одного студента
        System.out.println();
        double gpaToUpdate = 3.85;
        Student toUpdate = students.get("ID42026");
        toUpdate.setGpa(gpaToUpdate);
        System.out.println(toUpdate.getName() + "'s gpa was updated to " + gpaToUpdate);
        for (Map.Entry<String, Student> entry : students.entrySet()){
            Student s = entry.getValue();
            System.out.println("ID: " + entry.getKey() + ", " + s);
        }

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        System.out.println();
        List<Student> studentList = new ArrayList<>(students.values());
        System.out.println("---Unsorted List---");
        System.out.println(studentList);

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        System.out.println("---Sorted List By Comparable---");
        Collections.sort(studentList);
        System.out.println(studentList);

        System.out.println("---Sorted List By Comparator---");
        studentList.sort(new StudentComparator());
        System.out.println(studentList);

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        int k = Math.min(students.size(), 3);
//        if(students.size() >= 3){
//            k = 3;
//        } else {
//            k = students.size();
//        }
        List<Student> topKTask = new ArrayList<>(students.values());
        Collections.sort(topKTask);
        List<Student> topKSorted = new ArrayList<>(topKTask.subList(0,k));
        System.out.println(topKSorted);

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента

//      Идея в том чтобы хранить в Double gpa и в List список студентов с тем gpa что и в key.
        List<Student> task3List = new ArrayList<>(students.values());
        Map<Double, List<Student>> groups = new HashMap<>();
        for (Student s : task3List){
            double gpa = s.getGpa();
            if(!groups.containsKey(gpa)){
                groups.put(gpa, new ArrayList<>());
            }
            groups.get(gpa).add(s);
        }

        for (Map.Entry<Double, List<Student>> entry : groups.entrySet()){
            if (entry.getValue().size() > 1){
                System.out.println("GPA: " + entry.getKey());
                for (Student s : entry.getValue()){
                    System.out.println(s);
                }
            }
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course cs = new Course("Computer Science");
        Course cyber = new Course("CyberSecurity");
        courseMap.put(cs, new ArrayList<>());
        courseMap.get(cs).add(stud2);
        courseMap.get(cs).add(stud1);
        courseMap.get(cs).add(stud4);
        courseMap.put(cyber, new ArrayList<>());
        courseMap.get(cyber).add(stud10);
        courseMap.get(cyber).add(stud5);

        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()){
            System.out.println(entry.getKey());
            for (Student s : entry.getValue()){
                System.out.println(s);
            }
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        List<Student> task5List = new ArrayList<>(students.values());
        task5List.sort(new StudentComparator());
        for (Student s : task5List){
            System.out.println(s);
        }
    }
}



