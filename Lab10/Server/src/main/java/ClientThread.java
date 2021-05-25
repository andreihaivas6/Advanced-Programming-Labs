import java.awt.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

class ClientThread extends Thread {
    private AccountsList accountsList;
    private Socket socket = null;

    public ClientThread (Socket socket, AccountsList accountsList) {
        this.socket = socket ;
        this.accountsList = accountsList;
    }


    public void run () {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String response = getResponse(request);
                out.println(response);
                out.flush();

                if(response.equals("Bye!")) {
                    break;
                } else if (response.equals("Server stopped.")) {
                    accountsList.setStop(true);
//                    System.exit(1);
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public String getResponse(String request) throws IOException {
        if(accountsList.getStop()) {
            return exit();
        }
        String[] arguments = request.split(" +");
        String command = arguments[0];
        return switch (command) {
            case "register" -> register(arguments[1]);
            case "login"    -> login(arguments[1]);
            case "friend"   -> friend(arguments);
            case "message"  -> message(request);
            case "read"     -> read();
            case "exit"     -> exit();
            case "stop"     -> stop1();
            case "data"     -> data();
            case "cohesion" -> cohesion();
            default         -> "Wrong command";
        };
    }

    private String register(String name) {
        if(accountsList.indexOfName(name) == -1) {
            accountsList.addAccount(new Account(name));
            return "Account created.";
        } else {
            return "Account already exists.";
        }
    }

    private String login(String name) {
        if(accountsList.indexOfName(name) == -1) {
            return "Account doesn't exist.";
        } else {
            if (accountsList.logIn(socket, name)) {
                return "You have been logged id.";
            } else {
                return "Account already connected.";
            }
        }
    }

    private String friend(String[] arguments) {
        Account currentAccount = accountsList.getAccountBySocket(socket);
        for(int i = 1; i < arguments.length; ++i) {
            Account friendAccount = accountsList.getAccountByName(arguments[i]);
            if(friendAccount != null) {
                currentAccount.addFriend(friendAccount);
                friendAccount.addFriend(currentAccount);
            }
        }
        return "Friends added.";
    }

    private String message(String request) {
        String[] message = request.split(" +", 2);

        Account currentAccount = accountsList.getAccountBySocket(socket);
        for(Account account : currentAccount.getFriends()) {
            account.addMessageFromAccount(currentAccount, message[1]);
        }
        return "Message sent";
    }

    private String read() {
        Account currentAccount = accountsList.getAccountBySocket(socket);
        return currentAccount.getMessagesAsString();
    }

    private String exit() {
        Account currentAccount = accountsList.getAccountBySocket(socket);
        currentAccount.setLoggedIn(false);
        return "Bye!";
    }

    private String stop1() {
        return "Server stopped.";
    }

    private String data() throws IOException {
        new Data(accountsList);
        Desktop.getDesktop().open(new File("data.html"));
        return "Statistics created.";
    }

    private String cohesion() {
        int numberConnectedAccounts = 0;
        Map<Account, Integer> connectedAccounts = new HashMap<>();
        for(Account account : accountsList.getAccounts()) {
            if(account.getLoggedIn() && !connectedAccounts.containsKey(account)) {
                connectedAccounts.put(account, numberConnectedAccounts++);
            }
        }
        StructuralCohesion structuralCohesion
                = new StructuralCohesion(numberConnectedAccounts, connectedAccounts, accountsList);
        return "Structural cohesion: " + structuralCohesion.solve().toString();
    }
}