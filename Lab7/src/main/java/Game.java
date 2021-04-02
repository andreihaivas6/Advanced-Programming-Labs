import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Game {
    private int turn; // indicele jucatorului curent
    private List<Player> players = new ArrayList<>();

    private final int matrixDim;
    private final int numberTokens;
    private List<Token> availableTokens = new ArrayList<>();

    public Game(int matrixDim, int numberTokens) {
        turn = 0;
        this.matrixDim = matrixDim;
        this.numberTokens = numberTokens;
        generateBoard();
    }

    private void generateBoard() {
        if(numberTokens <= 0 || numberTokens > matrixDim * (matrixDim - 1) || matrixDim <= 0) {
            throw new RuntimeException("Input naspa");
        }

        for(int i = 0; i < numberTokens; ++i) {
            int ind1 = (int)(Math.random() * matrixDim) + 1;
            int ind2 = (int)(Math.random() * matrixDim) + 1;
            while (ind2 == ind1) { // sa nu avem token invalid
                ind2 = (int)(Math.random() * matrixDim) + 1;
            }
            int value = (int)(Math.random() * 10) + 1;

            // verificam sa nu existe deja tokenul
            boolean exista = false;
            Token token = new Token(ind1, ind2, value);
            for (Token availableToken : availableTokens) {
                if (token.equals(availableToken)) {
                    exista = true;
                    break;
                }
            }

            if (!exista) {
                availableTokens.add(token);
            } else {
                i--;
            }
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }


    public synchronized Token getToken(int index) throws InterruptedException {
        while (index != turn) { // isi asteapta randul
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (availableTokens.size() == 0) {
            turn = (turn + 1) % players.size();
            notifyAll();
            return null;
        }
        sleep(500);

        int indexTokenRandom = (int) (Math.random() * getAvailableTokens().size());
        Token token = getAvailableTokens().get(indexTokenRandom);
        availableTokens.remove(token);

        turn = (turn + 1) % players.size(); // urmatorul jucator
        notifyAll();

        return token;
    }


    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Token> getAvailableTokens() {
        return availableTokens;
    }

    public void setAvailableTokens(List<Token> availableTokens) {
        this.availableTokens = availableTokens;
    }
}
