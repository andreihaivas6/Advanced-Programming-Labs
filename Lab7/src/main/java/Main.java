public class Main {
    public static void main(String[] args) throws InterruptedException {
        int indexPlayer = 0;

        Game game = new Game(3); // Bots Contests
        Player player1 = new Player(indexPlayer++, "Player1" , game);
        Player player2 = new Player(indexPlayer++, "Player2" , game);

        game.addPlayer(player1);
        game.addPlayer(player2);

        TimeKeeper timeKeeper = new TimeKeeper(30);
        new Thread(timeKeeper).start();

        Thread t1 = new Thread(player1);
        Thread t2 = new Thread(player2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(player1.getSequences());
        System.out.println(player2.getSequences());
        player1.computeScoreNormal();
        player2.computeScoreNormal();

        timeKeeper.setGameIsOver(true);
        if(player1.getScore() == player2.getScore()) {
            System.out.println("Egalitate");
        } else if(player1.getScore() > player2.getScore()) {
            System.out.println("Player 1 a castigat");
        } else {
            System.out.println("Player 2 a castigat");
        }
        System.out.println("Jocul a durat " + timeKeeper.getNrSec() + " secunde.");
    }
}
