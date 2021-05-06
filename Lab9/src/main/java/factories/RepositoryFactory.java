package factories;

import repositories.MovieRepository;
import repositories.MovieRepositoryFromAbstract;

import java.sql.SQLException;

public class RepositoryFactory extends AbstractFactory<MovieRepositoryFromAbstract> {
    @Override
    public MovieRepositoryFromAbstract getMovieManager() throws SQLException {
        return new MovieRepositoryFromAbstract();
    }
}
