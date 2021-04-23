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

    public synchronized Token getTokenByRobotSmart(Player player) throws InterruptedException { // smart player
        /*
        smart:
            -> alege tokenuri cu valoarea cea mai mare
            -> cand e posibil, alege tokenuri de care ar avea nevoie ceilalti jucatori
         */

        while (player.getIndex() != turn) { // isi asteapta randul
            wait();
        }

        if (availableTokens.size() == 0) {
            turn = (turn + 1) % players.size();
            notifyAll();
            return null;
        }

        Token chosenToken;
        if(!player.getHasSequenceStarted()) { // daca nu a inceput o secventa noua, alegem tokenul cu cea mai mare valoare
            chosenToken = getMaxToken(availableTokens);

            player.setHasSequenceStarted(true);
            player.setFirstIndexFromSequence(chosenToken.getIndex1());

        } else { // daca are o secventa inceputa, alegem un token care sa continue ultimul token extras
            // si care sa incurce ceilalti jucatori, si/sau sa fie de valoare maxima

            Token lastToken = player.getSelectedTokens().get(player.getSelectedTokens().size() - 1);
            int index = lastToken.getIndex2();

            List<Token> tokensWhichEnemiesNeed = getTokensWhichEnemiesNeed(player);
            if(tokensWhichEnemiesNeed.size() != 0) { // alegem cel mai mare Token de care ar avea nevoie inamicii
                chosenToken = getMaxToken(tokensWhichEnemiesNeed);
            } else { // daca nu sunt tokenuri posibile de care ar avea nevoie inamicii, luam cel mai mare token disponibil
                List<Token> possibleTokens = availableTokens
                        .stream()
                        .filter(token -> index == token.getIndex1())
                        .collect(Collectors.toList());

                if(possibleTokens.size() != 0) { // daca mai sunt tokenuri disponibile care sa respecte conditia
                    chosenToken = getMaxToken(possibleTokens);
                } else { // daca nu mai sunt tokenuri disponibile, secventa curenta nu poate fi dusa la capat, deci nu valoreaza nimic
                    chosenToken = availableTokens.get((int) (Math.random() * getAvailableTokens().size()));
                    player.setHasSequenceStarted(false);
//                    player.getSelectedTokens().clear(); //         !!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
                }
            }
        }

        turn = (turn + 1) % players.size(); // urmatorul jucator
        notifyAll();

        availableTokens.remove(chosenToken);
        return chosenToken;
    }

    public List<Token> getTokensWhichEnemiesNeed(Player player) {
        if(player.getSelectedTokens().size() == 0) {
            return new ArrayList<>();
        }

        int nodCurent = player.getSelectedTokens().get(player.getSelectedTokens().size() - 1).getIndex2();
        List<Player> enemiesInSameNode = players.stream()
                .filter(p -> p.getSelectedTokens().size() > 0 && !p.equals(player)
                        && p.getSelectedTokens().get(p.getSelectedTokens().size() - 1).getIndex2() == nodCurent)
                .collect(Collectors.toList());

        List<Token> tokensWhichEnemiesNeeds = new ArrayList<>();
        for (Player player1 : enemiesInSameNode) {
            for(Token token : availableTokens) {
                if(token.getIndex1() == nodCurent && token.getIndex2() == player1.getFirstIndexFromSequence()) {
                    tokensWhichEnemiesNeeds.add(token);
                }
            }
        }

        return tokensWhichEnemiesNeeds;
    }

    public Token getMaxToken(List<Token> tokens) {
        if(tokens.size() == 0) {
            return null;
        }
        Token maxToken = tokens.get(0);
        for(Token token : tokens) {
            if(token.getValue() > maxToken.getValue()) {
                maxToken = token;
            }
        }
        return maxToken;
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

    public int getMatrixDim() {
        return matrixDim;
    }
}
