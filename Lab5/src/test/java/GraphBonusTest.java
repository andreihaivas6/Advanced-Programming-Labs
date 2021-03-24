import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GraphBonusTest {
    @Test
    public void evaluate() throws Exception {
        Catalog catalog = new Catalog("MyCatalog");

        List<Item> items = new ArrayList<>();
        for(int i = 1; i <= 10_000; ++i){
            items.add(new Book("numeCarte" + i,
                    "C:\\users\\andre\\Desktop\\testBook.pdf", "Robert", 2010));
        }
        for(int i = 1; i <= 10_000; ++i){
            items.add(new Song("numeCantec" + i,
                    "C:\\users\\andre\\Desktop\\testSong.mp3", "Ludovic"));
        }
        items.add(new Song("cantecCuCantaretUnic",
                "C:\\users\\andre\\Desktop\\testSong.mp3", "Alt Cantaret"));
        catalog.setItems(items);


        GraphBonus graph = new GraphBonus(catalog);
        graph.createGraph();
        graph.solve();
        System.out.println(graph);

        HashMap<Integer, List<Item>> expectedPlaylist = new HashMap<>();
        expectedPlaylist.put(1, Arrays.asList(items.get(0), items.get(10_000), items.get(20_000)));
        for(int i = 1; i < 10_000; ++i) {
            expectedPlaylist.put(i + 1, Arrays.asList(items.get(i), items.get(10_000 + i)));
        }

        assertEquals(graph.getPlaylist(), expectedPlaylist);
    }
}
