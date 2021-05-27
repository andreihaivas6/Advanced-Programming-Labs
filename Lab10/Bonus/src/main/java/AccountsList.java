import java.net.Socket;
import java.util.ArrayList;

public class AccountsList {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Boolean stop = false;

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void deleteAccount(Account account) {
        accounts.remove(account);
    }

    public int indexOfName(String name) { // -1, daca nu exista
        for(Account account : accounts) {
            if (account.getName() != null && account.getName().equals(name)) {
                return accounts.indexOf(account);
            }
        }
        return -1;
    }

    public Boolean logIn(Socket socket, String name) {
        // stergem clientul care retine doar socket-ul si il ducem la cel ce are numele
        accounts.removeIf(account -> account.getSocket() == socket && account.getName() == null);

        // clientul ce contine numele va primi socketul (daca nu e deja logat)
        for (Account account : accounts) {
            if(account.getName() != null && account.getName().equals(name)) {
                if(account.getLoggedIn()) {
                    return false;
                } else {
                    account.setSocket(socket);
                    account.setLoggedIn(true);
                    return true;
                }
            }
        }
        return false;
    }

    public Account getAccountByName(String name) {
        for(Account account : accounts) {
            if(account.getName() != null && account.getName().equals(name)) {
                return account;
            }
        }
        return null;
    }

    public Account getAccountBySocket(Socket socket) {
        for(Account account : accounts) {
            if(account.getSocket() == socket) {
                return account;
            }
        }
        return null;
    }

    public long getLoggedInAccountsSize() {
        return accounts.stream()
                .filter(Account::getLoggedIn)
                .count();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }
}
