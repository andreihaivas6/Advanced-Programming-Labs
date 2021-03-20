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
        catalog.load(super.getArguments().get(0));
    }
}
