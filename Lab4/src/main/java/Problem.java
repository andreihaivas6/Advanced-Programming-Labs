import java.util.List;
import java.util.Map;

public class Problem {
    // vom tine minte si o lista ce memoreaza valori pentru prioritati
    // S1: H1, [H2, H3] -> S1: 1, 2, 2
    private Map<Student, List<School>>  studentsPreferences;
    private Map<Student, List<Integer>> studentsPreferencesValues;
    private Map<School,  List<Student>> schoolsPreferences;
    private Map<School,  List<Integer>> schoolsPreferencesValues;


    public Problem(Map<Student, List<School>> studentsPreferences, Map<School, List<Student>> schoolsPreferences) {
        this.studentsPreferences = studentsPreferences;
        this.schoolsPreferences = schoolsPreferences;
    }

    public Problem(Map<Student, List<School>> studentsPreferences, Map<Student, List<Integer>> studentsPreferencesValues,
                   Map<School, List<Student>> schoolsPreferences, Map<School, List<Integer>> schoolsPreferencesValues) {
        this.studentsPreferences = studentsPreferences;
        this.studentsPreferencesValues = studentsPreferencesValues;
        this.schoolsPreferences = schoolsPreferences;
        this.schoolsPreferencesValues = schoolsPreferencesValues;
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

    public Map<Student, List<Integer>> getStudentsPreferencesValues() {
        return studentsPreferencesValues;
    }

    public void setStudentsPreferencesValues(Map<Student, List<Integer>> studentsPreferencesValues) {
        this.studentsPreferencesValues = studentsPreferencesValues;
    }

    public Map<School, List<Integer>> getSchoolsPreferencesValues() {
        return schoolsPreferencesValues;
    }

    public void setSchoolsPreferencesValues(Map<School, List<Integer>> schoolsPreferencesValues) {
        this.schoolsPreferencesValues = schoolsPreferencesValues;
    }
}
