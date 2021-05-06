package daos;

import java.sql.*;

public class MovieDAO {
    private Connection conn = DatabaseConnection.makeConnection();

    public MovieDAO() throws SQLException {  }

    public void insert(int id, String title, Date date, int duration, int score) throws SQLException {
        String sql = "INSERT INTO MOVIES VALUES(?, ?, ?, ?, ?);";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, id);
        statement.setString(2, title);
        statement.setDate(3, date);
        statement.setInt(4, duration);
        statement.setInt(5, score);
        statement.execute();
    }

    public Movie selectId (int id) throws SQLException {
        String sql = "SELECT * FROM movies WHERE id=?;";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        result.next();

        Movie movie = new Movie();
        movie.setId(result.getInt("id"));
        movie.setTitle(result.getString("title"));
        movie.setReleaseDate(result.getDate("release_date"));
        movie.setDuration(result.getInt("duration"));
        movie.setScore(result.getInt("score"));

        return movie;
    }

    public Movie selectTitle (String name) throws SQLException {
        String sql = "SELECT * FROM movies WHERE title=?;";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        result.next();

        Movie movie = new Movie();
        movie.setId(result.getInt("id"));
        movie.setTitle(result.getString("title"));
        movie.setReleaseDate(result.getDate("release_date"));
        movie.setDuration(result.getInt("duration"));
        movie.setScore(result.getInt("score"));

        return movie;
    }
}
