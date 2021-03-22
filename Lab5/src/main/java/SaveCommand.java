import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
public class SaveCommand extends Command {

    public SaveCommand(List<String> arguments) {
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
        //-> avem try with resources -> inchide singur tot ce e closeable
        // nu e necesar out.close();fileOut.close();

        String path = getArguments().get(0);
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut);) {
            out.writeObject(catalog);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
