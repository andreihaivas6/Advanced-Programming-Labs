import java.util.List;

public class AddCommand extends Command {

    public AddCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public void tryArguments() {
        if ((super.getArguments().get(0).equals("Song") && super.getArguments().size() != 4)
                || (super.getArguments().get(0).equals("Book") && super.getArguments().size() != 5)) {
            throw new IllegalArgumentException("Argumente gresite");
        }
    }

    @Override
    public void run(Catalog catalog) throws Exception {
        List<String> arg = super.getArguments();
        if(super.getArguments().get(0).equals("Song")) {
            catalog.add(new Song(arg.get(1), arg.get(2), arg.get(3)));
        } else {
            catalog.add(new Book(arg.get(1), arg.get(2), arg.get(3), Integer.parseInt(arg.get(4))));
        }
    }
}
