import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadCommand extends Command {

    public LoadCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public void tryArguments() {
        if (super.getArguments().size() != 1) {
            throw new IllegalArgumentException("Argumente gresite");
        }
    }

    @Override
    public void run(Catalog catalog) {
        String path = getArguments().get(0);
        Item.tryPath(path);

        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Catalog auxCatalog = (Catalog) in.readObject();
            catalog.setName(auxCatalog.getName());
            catalog.setItems(auxCatalog.getItems());
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
