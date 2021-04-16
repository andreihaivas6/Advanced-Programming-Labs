import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    public static Connection makeConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab8","root","");
        }
        return connection;
    }
}
