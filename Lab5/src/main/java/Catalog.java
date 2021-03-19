import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    // toate campurile din clasa trebuie sa fie Serializable (inclusiv Item)
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void list() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", \nitems=" + items +
                '}';
    }

    public void play(Item itemToOpen) throws Exception {
//        items.stream().map(item -> item.equals(itemToOpen))
//                .findFirst().orElseThrow(() -> new RuntimeException("Item-ul nu exista."));

        for (Item item : items) {
            if (item.equals(itemToOpen)) {
                if (!Desktop.isDesktopSupported()) {
                    // RuntimeException nu are nevoie de throws Exception
                    throw new RuntimeException("Desktop nu este suportat de sistem.");
                }
                File file = new File(itemToOpen.getPath());
                Desktop.getDesktop().open(file);
                return;
            }
        }

        throw new FileNotFoundException("Item-ul nu exista.");
    }

    public void save() {
        try (FileOutputStream fileOut = new FileOutputStream("catalog.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut);) {
            out.writeObject(this);
//            out.close();
//            fileOut.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void load(String path) {
        Item.tryPath(path);
        try (FileInputStream fileIn = new FileInputStream("catalog.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            // this = catalog; !!!
            Catalog catalog = (Catalog) in.readObject();
            this.setName(catalog.getName());
            this.setItems(catalog.getItems());

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
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
