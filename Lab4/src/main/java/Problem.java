import java.util.List;
import java.util.Map;

public class Problem {
    private Map<Student, List<School>> studentsPreferences;
    private Map<School, List <Student>> schoolsPreferences;

    public Problem(Map<Student, List<School>> studentsPreferences, Map<School, List<Student>> schoolsPreferences) {
        this.studentsPreferences = studentsPreferences;
        this.schoolsPreferences = schoolsPreferences;
    }

    public Map<Student, List<School>> getStudentsPreferences() {
        return studentsPreferences;
    }

    public void setStudentsPreferences(Map<Student, List<School>> studentsPreferences) {
        this.studentsPreferences = studentsPreferences;
    }

    public Map<School, List<Student>> getSchoolsPreferences() {
        return schoolsPreferences;
    }

    public void setSchoolsPreferences(Map<School, List<Student>> schoolsPreferences) {
        this.schoolsPreferences = schoolsPreferences;
    }
}
