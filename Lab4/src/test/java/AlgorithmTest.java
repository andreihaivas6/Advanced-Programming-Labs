import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmTest {
    @Test
    public void evaluatesExpression() {
        Student student1 = new Student("S1", 9);
        Student student2 = new Student("S2", 5);
        School  school1 = new School("H1", 1);
        School  school2 = new School("H2", 1);

        Map<Student, List<School>> studPref = new HashMap<>();
        studPref.put(student1, Arrays.asList(school1));
        studPref.put(student2, Arrays.asList(school2));

        Map<School, List<Student>> schPref = new HashMap<>();
        schPref.put(school1, Arrays.asList(student1));
        schPref.put(school2, Arrays.asList(student2));


        Problem problem = new Problem(studPref, schPref);
        Solution solution = new Solution(problem);
        solution.solve();

        Map<Student, School> expectedResult = new HashMap<>();
        expectedResult.put(student1, school1);
        expectedResult.put(student2, school2);
        assertEquals(expectedResult, solution.getResult());
    }
}