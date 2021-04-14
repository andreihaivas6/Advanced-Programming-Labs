import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class Game {
    private int turn; // indicele jucatorului curent
    private List<Player> players = new ArrayList<>();

    private final int matrixDim;
    private List<Token> availableTokens = new ArrayList<>();

    public Game(int matrixDim) {
        turn = 0;
        this.matrixDim = matrixDim;
        generateBoard();
    }

    private void generateBoard() {
        for(int i = 0; i < matrixDim; ++i) {
            for(int j = 0; j < matrixDim; ++j) {
                if(i == j)
                    continue;
                int value = (int)(Math.random() * 10) + 1;
                availableTokens.add(new Token(i + 1, j + 1, value));
            }
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }


    public synchronized Token getTokenByRobot(Player player) throws InterruptedException {
        while (player.getIndex() != turn) { // isi asteapta randul
            wait();
        }

        if (availableTokens.size() == 0) {
            turn = (turn + 1) % players.size();
            notifyAll();
            return null;
        }
//        sleep(500);

        Token chosenToken;
        if(!player.getHasSequenceStarted()) { // daca nu a inceput o secventa noua, alegem un token random
            int indexTokenRandom = (int) (Math.random() * getAvailableTokens().size());
            chosenToken = getAvailableTokens().get(indexTokenRandom);

            player.setHasSequenceStarted(true);
            player.setFirstIndexFromSequence(chosenToken.getIndex1());

        } else { // daca are o secventa inceputa, alegem un token care sa continue ultimul token extras
            Token lastToken = player.getSelectedTokens().get(player.getSelectedTokens().size() - 1);
            int index = lastToken.getIndex2();

            List<Token> possibleTokens = availableTokens
                    .stream()
                    .filter(token -> index == token.getIndex1())
                    .collect(Collectors.toList());

            if(possibleTokens.size() != 0) { // daca mai sunt tokenuri disponibile care sa respecte conditia
                chosenToken = possibleTokens.get((int) (Math.random() * possibleTokens.size()));
            } else {
                chosenToken = availableTokens.get((int) (Math.random() * getAvailableTokens().size()));
                player.setHasSequenceStarted(false);
            }
        }

        turn = (turn + 1) % players.size(); // urmatorul jucator
        notifyAll();

        availableTokens.remove(chosenToken);
        return chosenToken;
    }

    public synchronized Token getTokenByHuman(Player player) throws InterruptedException {
        while(player.getIndex() != turn) {
            wait();
        }
        System.out.println(availableTokens);
        Scanner scanner = new Scanner(System.in);

        int i, j;
        do {
            if(availableTokens.size() == 0)
                return null;
            System.out.print("Introdu indicii tokenului ales\n--->");
            i = scanner.nextInt();
            System.out.print("--->");
            j = scanner.nextInt();
        }while(!availableTokens.contains(new Token(i, j, 0)));  // nu conteaza valoarea in equals()

        turn = (turn + 1) % players.size(); // urmatorul jucator
        notifyAll();

        for(Token token : availableTokens) {
            if(token.getIndex1() == i && token.getIndex2() == j) {
                availableTokens.remove(token);
                return token;
            }
        }
        return null;
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
