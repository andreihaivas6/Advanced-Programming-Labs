import java.sql.Connection;
import java.sql.SQLException;

public class MovieGenreDAO {
    private Connection conn = DatabaseConnection.makeConnection();

    public MovieGenreDAO() throws SQLException { }


}
