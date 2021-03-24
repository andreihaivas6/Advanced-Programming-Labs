import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student[] students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        School[] schools   = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i, 2))
                .toArray(School[]::new);
        schools[0].setCapacity(1);

//        Faker faker = new Faker();
//        for(Student student : students){
//            student.setName(faker.name().fullName());
//        }
//        for(School school : schools){
//            school.setName(faker.company().name() + " High School");
//        }

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

//        Am folosit Faker-ul mai sus (inainte de a creea noi obiecte) pentru a avea peste tot aceleasi nume.
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

        // Bonus I

        Arrays.stream(schools).forEach(x -> x.setCapacity(2));
        schools[0].setCapacity(1);

        solution.solveBonus();
        System.out.println("\nStable matching: " + solution);

        // Bonus II

        Arrays.stream(schools).forEach(x -> x.setCapacity(2));
        schools[0].setCapacity(1);

        Map <Student, List<Integer>> studentsPreferencesValues = new HashMap<>();
        studentsPreferencesValues.put(students[0], Arrays.asList(1, 2, 3));
        studentsPreferencesValues.put(students[1], Arrays.asList(1, 2, 2)); // ==
        studentsPreferencesValues.put(students[2], Arrays.asList(1, 2));
        studentsPreferencesValues.put(students[3], Arrays.asList(1, 2));

        Map <School, List<Integer>> schoolsPreferencesValues = new HashMap<>();
        schoolsPreferencesValues.put(schools[0], Arrays.asList(1, 2, 3, 4));
        schoolsPreferencesValues.put(schools[1], Arrays.asList(1, 2, 3));
        schoolsPreferencesValues.put(schools[2], Arrays.asList(1, 2, 3));

        problem = new Problem(studentsPreferences, studentsPreferencesValues,
                schoolsPreferences, schoolsPreferencesValues);
        solution = new Solution(problem);
        solution.solveBonusPreferencesNotStrict();
        System.out.println("\nMatching: " + solution);
        /*
        Observam ca dupa mai multe rulari putem obtine solutii diferite si de lungimi diferite.
        Pe acest exemplu diferenta a fost facuta de prioritatatile studentului S1: H0, [H1, H2].
            (H1 si H2 avand aceeasi prioritate)
        In rularea 1: pentru S1 algoritmul a ales scoala H2 care era libera (care era libera si a putut face asignarea).
        In rularea 2: pentru S1 algoritmul a ales scoala H1 care era deja plina si astfel S1 a ramas neasignat la scoala.
        In concluzie, in cazul problemei SAP cu "ties" obtinem rezultate diferite si de lungimi diferite ca mai jos:
        Rulare 1:
            Matching: Solution{
                Student{'S3', 9} = School{'H0'}
                Student{'S0', 8} = School{'H1'}
                Student{'S1', 10} = School{'H2'}
                Student{'S2', 2} = School{'H1'}
            }
        Rulare 2:
            Matching: Solution{
                Student{'S3', 3} = School{'H0'}
                Student{'S0', 7} = School{'H1'}
                Student{'S2', 4} = School{'H1'}
            }
         */
    }
}
