package factories;

import daos.MovieDAO;

import java.sql.SQLException;

public class DAOFactory extends AbstractFactory<MovieDAO> {
    @Override
    public MovieDAO getMovieManager() throws SQLException {
        return new MovieDAO();
    }
}
