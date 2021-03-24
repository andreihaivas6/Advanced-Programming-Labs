import java.util.*;

public class Solution {
    private Problem problem;
    private Map<Student, School> result = new HashMap<>();

    public Solution(Problem problem) {
        this.problem = problem;
    }

    public void solve() {
        // studentii ordonati descrescator dupa nota
        List<Student> studentsOrdered = new ArrayList<>(problem.getStudentsPreferences().keySet());
        studentsOrdered.sort((student1, student2) -> {
            if (student1.getMark() == null || student2.getMark() == null)
                return 0;
            return -student1.getMark().compareTo(student2.getMark());
        });

        for (Student student : studentsOrdered) {
            for (School school : problem.getStudentsPreferences().get(student)) {
                // verificam sa fie loc in scoala, si scoala sa il vrea pe student
                if (school.getCapacity() > 0 && problem.getSchoolsPreferences().get(school).contains(student)) {
                    school.setCapacity(school.getCapacity() - 1);
                    result.put(student, school);
                    break;
                }
            }
        }
    }

    public void solveBonus() {
        Map<School, List<Student>> acceptedList = new HashMap<>();
        for (School school : problem.getSchoolsPreferences().keySet()) {
            acceptedList.put(school, new ArrayList<>());
        }

        List<Student> freeStudents = new ArrayList<>(problem.getStudentsPreferences().keySet());
        for (int i = 0; i < freeStudents.size(); ++i) {
            Student student = freeStudents.get(i);
            for (School school : problem.getStudentsPreferences().get(student)) {
                if (acceptedList.get(school).size() < school.getCapacity()) { // daca mai e loc in scoala
                    acceptedList.get(school).add(student);
                    break;
                } else { // daca lista scolii e deja plina
                    List<Student> schoolPreference = problem.getSchoolsPreferences().get(school);

                    // verificam daca studentul curent e mai bun decat cel mai slab din lista (si ii inlocuim)
                    for (int j = schoolPreference.size() - 1; j >= 0; --j) {
                        if (schoolPreference.get(j).equals(student)) {
                            break;
                        } else if (acceptedList.get(school).contains(schoolPreference.get(j))) {
                            freeStudents.add(schoolPreference.get(j));
                            int index = acceptedList.get(school).indexOf(schoolPreference.get(j));
                            acceptedList.get(school).set(index, student);
                            break;
                        }
                    }
                }
            }
        }

        for (School school : acceptedList.keySet()) {
            for (Student student : acceptedList.get(school)) {
                result.put(student, school);
            }
        }
    }

    public void solveBonusPreferencesNotStrict() {
        Map<School, List<Student>> acceptedList = new HashMap<>();
        for (School school : problem.getSchoolsPreferences().keySet()) {
            acceptedList.put(school, new ArrayList<>());
        }

        List<Student> freeStudents = new ArrayList<>(problem.getStudentsPreferences().keySet());
        for (int i = 0; i < freeStudents.size(); ++i) {
            Student student = freeStudents.get(i);
            List <Integer> studentPriorityValues = problem.getStudentsPreferencesValues().get(student);

            // cautam scoli pe nivele de prioritate
            int minPriority = studentPriorityValues.get(0);
            int maxPriority = studentPriorityValues.get(studentPriorityValues.size() - 1);

            // luam toate prioritatile pe rand
            for(int priority = minPriority; priority <= maxPriority; ++priority) {
                int minIndex = studentPriorityValues.indexOf(priority);
                int maxIndex = (priority == maxPriority) // indexul urmatoarului nivel de prioritate
                        ? (studentPriorityValues.size()) : studentPriorityValues.indexOf(priority + 1);

                // luam o scoala random dintre cele cu acelasi nivel de prioritate
                int indexSchool = (int)(Math.random() * (maxIndex - minIndex)) + minIndex;
                School school = problem.getStudentsPreferences().get(student).get(indexSchool);

                if(!problem.getSchoolsPreferences().get(school).contains(student)) {
                    continue; // trecem mai departe daca scoala nu vrea sa il primeasca pe student
                }

                if (acceptedList.get(school).size() < school.getCapacity()) { // daca mai e loc in scoala
                    acceptedList.get(school).add(student);
                    break;
                } else { // daca lista scolii e deja plina
                    // verificam daca studentul curent e mai bun decat cel mai slab din lista (si ii inlocuim)
                    // la coada sunt cei mai slabi studenti

                    List<Student> schoolPreference = problem.getSchoolsPreferences().get(school);
                    for (int j = schoolPreference.size() - 1; j >= 0; --j) {
                        Student student2 = schoolPreference.get(j);
                        if (student2.equals(student)) { // cel mai slab e studentul pe care vrem sa il punem
                            break;
                        } else if (acceptedList.get(school).contains(student2)) {
                            // studentul curent e inainte studentului deja pus in lista.
                            // ca sa fie mai bun decat el trebuie sa aiba nivel de prioritate de o valoare mai mica
                            List<Integer> schoolPriorityValues = problem.getSchoolsPreferencesValues().get(school);

                            int priorityStudent1 = schoolPriorityValues.indexOf(schoolPreference.indexOf(student));
                            int priorityStudent2 = schoolPriorityValues.indexOf(schoolPreference.indexOf(student2));

                            if (priorityStudent1 < priorityStudent2) { // swap
                                freeStudents.add(student2);
                                int index = acceptedList.get(school).indexOf(student2);
                                acceptedList.get(school).set(index, student);
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (School school : acceptedList.keySet()) {
            for (Student student : acceptedList.get(school)) {
                result.put(student, school);
            }
        }
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Map<Student, School> getResult() {
        return result;
    }

    public void setResult(Map<Student, School> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Solution{\n");
        for (Student student : result.keySet()) {
            s.append(student).append(" = ").append(result.get(student)).append('\n');
        }
        s.append("}");
        return s.toString();
    }
}
