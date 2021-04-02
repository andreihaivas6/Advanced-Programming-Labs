public class Main {
    public static void main(String[] args) {
        int indexPlayer = 0;

        Game game = new Game(3, 6);
        Player player1 = new Player(0, "Player1" , game);
        Player player2 = new Player(1, "Player2" , game);

        game.addPlayer(player1);
        game.addPlayer(player2);

//        player1.start();
//        player2.start();
        new Thread(player1).start();
        new Thread(player2).start();
    }
}
