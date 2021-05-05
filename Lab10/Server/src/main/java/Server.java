import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8888;

    public Server() throws IOException {
        AccountsList accountsList = new AccountsList();
        /*
            o sa avem conturi doar cu socket (la inceput), conturi doar cu nume (pentru existenta numelor)
            cand un client se conecteaza la un cont -> se sterge clientul cu socket si se adauga socketul la clientul cu nume
         */

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();

                System.out.println("Successful connection.");
                accountsList.addAccount(new Account(socket));
                new ClientThread(socket, accountsList).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        }
    }

}