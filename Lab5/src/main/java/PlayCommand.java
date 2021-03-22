import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class PlayCommand extends Command{
    public PlayCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public void tryArguments() {
        if (super.getArguments().size() != 1) {
            throw new IllegalArgumentException("Argumente gresite");
        }
    }

    @Override
    public void run(Catalog catalog) throws Exception {
//        items.stream().map(item -> item.equals(itemToOpen))
//                .findFirst().orElseThrow(() -> new RuntimeException("Item-ul nu exista."));

        String nameOfItemToOpen = getArguments().get(0);

        for (Item item : catalog.getItems()) {
            if (item.getName().equals(nameOfItemToOpen)) {
                if (!Desktop.isDesktopSupported()) {
                    // RuntimeException nu are nevoie de throws Exception
                    throw new RuntimeException("Desktop nu este suportat de sistem.");
                }
                File file = new File(item.getPath());
                Desktop.getDesktop().open(file);
                return;
            }
        }

        throw new FileNotFoundException("Item-ul nu exista.");
    }
}
