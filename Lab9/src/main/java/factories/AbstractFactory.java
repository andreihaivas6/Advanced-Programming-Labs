package factories;

import java.sql.SQLException;

public abstract class AbstractFactory<T> {
    public abstract T getMovieManager() throws SQLException;
}
