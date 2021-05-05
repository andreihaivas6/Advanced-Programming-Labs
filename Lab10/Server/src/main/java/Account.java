import java.net.Socket;
import java.util.*;

public class Account {
    private String name = null;
    private Socket socket;
    private Boolean loggedIn = false;
    private Set<Account> friends = new HashSet<>();
    private Map<Account, ArrayList<String>> messages = new HashMap<>();

    public Account(Socket socket) {
        this.socket = socket;
    }

    public void addFriend(Account account) {
        friends.add(account);
    }

    public void addMessageFromAccount(Account account, String message) {
        if(messages.containsKey(account)) {
            messages.get(account).add(message);
        } else {
            messages.put(account, new ArrayList<>(Collections.singleton(message)));
        }
    }

    public String getMessagesAsString() {
        StringBuilder result = new StringBuilder();
        for(Account account : messages.keySet()) {
            result.append(account.getName()).append(" { ");
            for(String message : messages.get(account)) {
                result.append("[").append(message).append("] ");
            }
            result.append("} ");
        }
        return result.toString();
    }

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Set<Account> getFriends() {
        return friends;
    }

    public void setFriends(Set<Account> friends) {
        this.friends = friends;
    }
}
