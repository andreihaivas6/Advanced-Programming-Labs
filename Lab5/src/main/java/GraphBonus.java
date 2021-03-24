import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GraphBonus {
    private Catalog catalog;
    private int nrNoduri;
    private int[][] matriceAdiacenta;
    // m[i][j] = 1 -> item-ul de pe poz i si item-ul de pe poz j din catalog.getItems() au ceva in comun
    private int nrColors;
    private HashMap<Integer, List<Item>> playlist = new HashMap<>();

    public GraphBonus(Catalog catalog) {
        this.catalog = catalog;
    }

    public void createGraph() {
        nrNoduri = catalog.getItems().size();
        matriceAdiacenta = new int[nrNoduri][nrNoduri];

        List<Item> items = catalog.getItems();
        for (int i = 0; i < nrNoduri; ++i) {
            for (int j = i; j < nrNoduri; ++j) {
                // adaugam cartile cu acelasi autor si cantecele cu acelasi cantaret
                if (items.get(i) instanceof Book && items.get(j) instanceof Book) {
                    if (((Book) items.get(i)).getAuthor().equals(((Book) items.get(j)).getAuthor())) {
                        matriceAdiacenta[i][j] = matriceAdiacenta[j][i] = 1;
                    }
                } else if (items.get(i) instanceof Song && items.get(j) instanceof Song) {
                    if (((Song) items.get(i)).getSinger().equals(((Song) items.get(j)).getSinger())) {
                        matriceAdiacenta[i][j] = matriceAdiacenta[j][i] = 1;
                    }
                }
            }
        }
    }

    public void solve() {
        int[] itemsColors = new int[nrNoduri];
        Arrays.fill(itemsColors, -1);

        itemsColors[0] = 0;
        nrColors = 1;

        for (int i = 1; i < nrNoduri; ++i) {
            boolean[] neighboursColors = new boolean[nrColors + 1]; // memoram culorile vecinilor
            Arrays.fill(neighboursColors, false);

            for (int j = 0; j < nrNoduri; ++j) { // luam toti vecinii care au deja culori
                if (matriceAdiacenta[i][j] == 1 && itemsColors[j] != -1) {
                    neighboursColors[itemsColors[j]] = true;
                }
            }

            for (int k = 0; k < neighboursColors.length; ++k) { // cautam prima culoare disponibila
                if (!neighboursColors[k]) {
                    itemsColors[i] = k;
                    if (k == nrColors) {
                        nrColors++;
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < nrColors; ++i) {
            playlist.put(i + 1, new ArrayList<>());
        }
        for (int i = 0; i < nrNoduri; ++i) {
            int zi = itemsColors[i] + 1;
            playlist.get(zi).add(catalog.getItems().get(i));
        }
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Playlist: \n");
        for (Integer zi : playlist.keySet()) {
            s.append(zi).append(" -> ").append
                    (playlist.get(zi).stream().map(Item::getName).collect(Collectors.toList())).append("\n");
        }
        return s.toString();
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public int getNrNoduri() {
        return nrNoduri;
    }

    public void setNrNoduri(int nrNoduri) {
        this.nrNoduri = nrNoduri;
    }

    public int[][] getMatriceAdiacenta() {
        return matriceAdiacenta;
    }

    public void setMatriceAdiacenta(int[][] matriceAdiacenta) {
        this.matriceAdiacenta = matriceAdiacenta;
    }

    public int getNrColors() {
        return nrColors;
    }

    public void setNrColors(int nrColors) {
        this.nrColors = nrColors;
    }

    public HashMap<Integer, List<Item>> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(HashMap<Integer, List<Item>> playlist) {
        this.playlist = playlist;
    }
}
