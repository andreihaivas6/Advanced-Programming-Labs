import java.util.List;

public abstract class Command {
    private List<String> arguments;

    public Command(List<String> arguments) {
        this.arguments = arguments;
        tryArguments();
    }

    public abstract void tryArguments();

    public abstract void run(Catalog catalog) throws Exception;

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}
