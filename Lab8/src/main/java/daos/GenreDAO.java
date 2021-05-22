package daos;

import others.DatabaseConnection;
import tables.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreDAO {

    private Connection conn = DatabaseConnection.makeConnection();

    public GenreDAO() throws SQLException { }

    public void insert(int id, String genre) throws SQLException {
        String sql = "INSERT INTO genres VALUES(?, ?);";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, id);
        statement.setString(2, genre);
        statement.execute();
    }

    public Genre selectId (int id) throws SQLException {
        String sql = "SELECT * FROM genres WHERE id=?;";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        result.next();

        Genre genre = new Genre();
        genre.setId(result.getInt("id"));
        genre.setName(result.getString("name"));

        return genre;
    }

    public Genre selectName (String name) throws SQLException {
        String sql = "SELECT * FROM genres WHERE name=?;";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        result.next();

        Genre genre = new Genre();
        genre.setId(result.getInt("id"));
        genre.setName(result.getString("name"));

        return genre;
    }
}
