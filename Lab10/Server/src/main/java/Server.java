import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Server {
    public static final int PORT = 8888;
    public static final String SERVER_ADRESS = "127.0.0.1";

    public Server() throws IOException {
        AccountsList accountsList = new AccountsList();
        /*
            o sa avem conturi doar cu socket (la inceput), conturi doar cu nume (pentru existenta numelor)
            cand un client se conecteaza la un cont -> se sterge clientul cu socket si se adauga socketul la clientul cu nume
         */

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (!accountsList.getStop()) {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(2 * 60 * 1000);

                if(accountsList.getStop()) {
                    socket.close();
                    break;
                }

                System.out.println("Successful connection.");
                accountsList.addAccount(new Account(socket));
                new ClientThread(socket, accountsList).start();
            }
            while(accountsList.getLoggedInAccountsSize() != 0) {
                System.out.println("Inca aici");
                sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Ooops... " + e);
        }
    }

}