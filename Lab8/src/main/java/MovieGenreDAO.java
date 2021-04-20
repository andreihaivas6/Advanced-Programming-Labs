import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieGenreDAO {
    private Connection conn = DatabaseConnection.makeConnection();

    public MovieGenreDAO() throws SQLException { }

    public void insert(int idFilm, int idGen) throws SQLException {
        String sql = "INSERT INTO tip_filme VALUES(?, ?);";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, idFilm);
        statement.setInt(2, idGen);
        statement.execute();
    }
}
