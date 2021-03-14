import com.github.javafaker.Faker;

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

        Faker faker = new Faker();
        for(Student student : students){
            student.setName(faker.name().fullName());
        }
        for(School school : schools){
            school.setName(faker.company().name() + " High School");
        }

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
//        for(School school : schoolsPreferences.keySet()){
//            System.out.println(school + ": " + schoolsPreferences.get(school));
//        }

        // Optional
        List <School> scoli = Arrays.asList(schools[0], schools[1]);
        System.out.println("\nStudentii care accepta ca scoli: " + scoli);
        studentList.stream()
                .filter(student -> studentsPreferences.get(student).containsAll(scoli))
                .forEach(System.out::println);

        Student topStudent = students[0];
        System.out.println("\nScolile care au ca prima preferinta pe: " + topStudent);
        schoolSet.stream()
                .filter(school -> schoolsPreferences.get(school).get(0) == topStudent)
                .forEach(System.out::println);

//        Am folosit Faker-ul mai sus (inainte de a creea noi obiecte).
//
//        Faker faker = new Faker();
//        for(Student student : students){
//            student.setName(faker.name().fullName());
//        }
//        for(School school : schools){
//            school.setName(faker.company().name() + " High School");
//        }


        for(Student student : students){
            student.setMark((int)(Math.random() * 10) + 1);
        }
        Problem problem = new Problem(studentsPreferences, schoolsPreferences);
        Solution solution = new Solution(problem);
        solution.solve();
        System.out.println("\nMatching: " + solution);

    }
}
