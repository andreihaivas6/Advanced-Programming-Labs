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
        catalog.save(super.getArguments().get(0));
    }
}
