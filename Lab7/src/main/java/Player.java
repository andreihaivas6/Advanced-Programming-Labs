import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player implements Runnable {
    private final int index;
    private final String name;
    private final Game game;
    private List<Token> selectedTokens = new ArrayList<>(); // o secventa la un mom dat (nu neaparat valida)
    private List<List<Token>> sequences = new ArrayList<>(); // toate secventele valide

    private boolean hasSequenceStarted;
    private int firstIndexFromSequence = -1;
    private int score;

    public Player(int index, String name, Game game) {
        this.index = index;
        this.name = name;
        this.game = game;
        hasSequenceStarted = false;
    }

    @Override
    public void run() {
        while (game.getAvailableTokens().size() != 0) { // cat timp mai sunt tokenuri disponibile
            Token token = null;
            try {
                token = game.getTokenByRobotSmart(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(token == null)
                break;
            selectedTokens.add(token);

            // s-a ales tokenul care incheie secventa
            if(firstIndexFromSequence == selectedTokens.get(selectedTokens.size() - 1).getIndex2()) {
                setHasSequenceStarted(false);
                addSequence();
            }
//            System.out.println(this + "a extras " + token);
        }
    }

    public void addSequence() {
        List<Token> auxList = new ArrayList<>(selectedTokens);
        sequences.add(auxList);
        selectedTokens.clear();
    }

    public void computeScoreNormal() {
        int score = 0;
        for(var list : sequences) { // avem doar secventele valide memorate
            for(Token token : list) {
                score += token.getValue();
            }
        }
        System.out.println("Scor calculat cu suma tuturor tokenurilor din secvente valide\n" + name + " are scorul: " + score);
        this.score = score;
    }

    public void computeScoreHamiltonian() {
        int score = 0;
        for(var list : sequences) {
            if(isHamiltonianCircuit(list)) {
                for(Token token : list) {
                    score += token.getValue();
                }
            }
        }
        System.out.println("Scor calculat cu suma tuturor tokenurilor din secvente ce sunt circuite hamiltoniene\n" + name + " are scorul: " + score);
        this.score = score;
    }

    public Boolean isHamiltonianCircuit(List<Token> list) {
        if(list.size() != game.getMatrixDim()) { // daca nu are lungimea egala cu nr de noduri
            return false;
        }

        // daca e format din n noduri, trebuie sa treaca o singura data prin fiecare nod
        Boolean[] nodes = new Boolean[game.getMatrixDim() + 1];
        Arrays.fill(nodes, false);

        for(Token token : list) {
            if(nodes[token.getIndex1()]) {
                return false;
            }
            nodes[token.getIndex1()] = true;
        }
        return true;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public List<Token> getSelectedTokens() {
        return selectedTokens;
    }

    public void setSelectedTokens(List<Token> selectedTokens) {
        this.selectedTokens = selectedTokens;
    }

    public boolean getHasSequenceStarted() {
        return hasSequenceStarted;
    }

    public void setHasSequenceStarted(boolean hasSequenceStarted) {
        this.hasSequenceStarted = hasSequenceStarted;
    }

    public int getFirstIndexFromSequence() {
        return firstIndexFromSequence;
    }

    public void setFirstIndexFromSequence(int firstIndexFromSequence) {
        this.firstIndexFromSequence = firstIndexFromSequence;
    }

    public List<List<Token>> getSequences() {
        return sequences;
    }

    public void setSequences(List<List<Token>> sequences) {
        this.sequences = sequences;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
