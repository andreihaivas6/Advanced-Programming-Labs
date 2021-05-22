import org.junit.Test;

import java.beans.JavaBean;

import static org.junit.Assert.assertEquals;

@JavaBean
public class TestLab {
    @Test
    public void evaluate2(int x) throws Exception {
        assertEquals(2, x);
    }

    @Test
    public void evaluate3(int x) throws Exception {
        assertEquals(3, x);
    }
}
