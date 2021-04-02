import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private final int index;
    private final String name;
    private final Game game;
    private List<Token> selectedTokens = new ArrayList<>();

    public Player(int index, String name, Game game) {
        this.index = index;
        this.name = name;
        this.game = game;
    }

    @Override
    public void run() {
        while (game.getAvailableTokens().size() != 0) { // cat timp mai sunt tokenuri disponibile
            Token token = null;
            try {
                token = game.getToken(index);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(token == null)
                break;
            selectedTokens.add(token);
            System.out.println(this + "a extras " + token);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
