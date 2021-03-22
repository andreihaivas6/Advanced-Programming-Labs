import java.util.List;

public class ListCommand extends Command{

    public ListCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public void tryArguments() {
        if (super.getArguments().size() != 0) {
            throw new IllegalArgumentException("Argumente gresite");
        }
    }

    @Override
    public void run(Catalog catalog) {
        System.out.println(catalog);
    }
}
