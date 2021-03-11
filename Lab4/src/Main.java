import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Student[] students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        School[] schools   = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i, 2))
                .toArray(School[]::new);
        schools[0].setCapacity(1);

        List<Student> studentList = new LinkedList<>(Arrays.asList(students));
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if(student1.getName() == null){
                    return 0;
                }
                return student1.getName().compareTo(student2.getName());
            }
        });
//        List<Student> newSortedList = studentList.stream()
//                .sorted(Student::compareByName)
//                .collect(Collectors.toList());

        Set<School> schoolSet = new TreeSet<>(Arrays.asList(schools));

        Map<Student, List<School>> studentsPreferences = new HashMap<>();
        studentsPreferences.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        studentsPreferences.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        studentsPreferences.put(students[2], Arrays.asList(schools[0], schools[1]));
        studentsPreferences.put(students[3], Arrays.asList(schools[0], schools[2]));

        Map<School, List<Student>> schoolsPreferences = new TreeMap<>();
        schoolsPreferences.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2]));
        schoolsPreferences.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        schoolsPreferences.put(schools[2], Arrays.asList(students[0], students[1], students[3]));

        for (Map.Entry<Student, List<School>> pair : studentsPreferences.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue().toString());
        }
        System.out.println();
        for (Map.Entry<School, List<Student>> pair :schoolsPreferences.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue().toString());
        }
    }
}
