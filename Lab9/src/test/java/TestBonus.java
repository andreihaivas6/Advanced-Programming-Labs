import org.junit.Test;

import java.io.IOException;

public class TestBonus {
    @Test
    public void Test() throws IOException {
        long start = System.currentTimeMillis();

        Bonus bonus = new Bonus();
        bonus.solve();
        bonus.printPlaylist();

        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memorie utilizata: " + memory / (1024 * 1024.) + " MB");

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Timp de rulare: " + (timeElapsed / 1e3) + "s");
    }
}
