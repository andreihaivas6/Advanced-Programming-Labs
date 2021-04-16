import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        GenreDAO genreDAO = new GenreDAO();
        MovieDAO movieDAO = new MovieDAO();
        movieGenreDAO movieGenreDAO = new movieGenreDAO();

//        movieDAO.insert(3, "film3", new Date(2003, 3, 3), 200, 5);
//        genreDAO.insert(3, "Comedie");
        System.out.println(movieDAO.selectId(1));
        System.out.println(movieDAO.selectTitle("film2"));
        System.out.println(genreDAO.selectId(1));
        System.out.println(genreDAO.selectName("Action"));
    }
}
