import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    // toate campurile din clasa trebuie sa fie Serializable (inclusiv Item)
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", \nitems=" + items +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
