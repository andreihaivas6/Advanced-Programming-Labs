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
        catalog.play(super.getArguments().get(0));
    }
}
