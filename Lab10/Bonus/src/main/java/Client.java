import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static String run() throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int port = 8888; // The server's port
        try (
                Socket socket = new Socket(serverAddress, port);

                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream()))
        ) {
            // Send a request to the server
//            while(true) {
                System.out.print("Introdu comanda.\n---> ");
                Scanner scan = new Scanner(System.in);
                String request = scan.nextLine();
                out.println(request);

                String response = in.readLine();
                System.out.println(response);
                if(response.equals("Bye!") || response.equals("Server stopped.")) {;
//                    break;
                    return "Bye!";
                }
//            }
        } catch (Exception e) {
            Main.serverId = -1;
        }
        return "";
    }
}