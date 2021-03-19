import java.io.File;
import java.io.Serializable;

public abstract class Item implements Serializable {
    private String name;
    private String path;

    public Item(String name, String path) {
        tryPath(path);
        this.name = name;
        this.path = path;
    }

    public static void tryPath(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new InvalidException("Path-ul: \"" + path + "\" nu exista.");
        }
        if (file.isDirectory()) {
            throw new InvalidException("Path-ul: \"" + path + "\" este un director.");
        }
        // InvalidException (definit de noi) / IllegalArgumentException mosteneste RuntimeException
        // deci nu are nevoie sa fie scris throws Exception
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
