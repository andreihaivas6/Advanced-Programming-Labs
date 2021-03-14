import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
