package bonus;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    private ConnectionPool() { }

    static {
        try {
            comboPooledDataSource.setDriverClass("org.mariadb.jdbc.Driver");
            comboPooledDataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/lab8");
            comboPooledDataSource.setUser("root");
            comboPooledDataSource.setPassword("");
        } catch (Exception ignored) { }
    }

    public static Connection getConnection() throws SQLException {
        return comboPooledDataSource.getConnection();
    }
}
