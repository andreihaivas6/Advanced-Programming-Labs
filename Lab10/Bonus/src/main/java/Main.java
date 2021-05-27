import java.io.IOException;

public class Main {
    public static Integer id = -1;
    public static Integer serverId = -1;



//    java -jar Bonus-1.0-SNAPSHOT.jar
    public static void main(String[] args) throws IOException {
        Integer currentId = ++id;
        while(true) {
            if(serverId == -1) { // server
                serverId = currentId;
                Server server = new Server();
            } else { // client
                if(Client.run().equals("Bye!")) {;
                    break;
                }
            }
        }
    }
}
