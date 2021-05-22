package bonus;

import others.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task implements Runnable {
    private int id;
    private String sql;
    private Integer option; // 1 -> Singleton Conection, 2 -> Connection Pool

    public Task(int id, String sql, Integer option) {
        this.id = id;
        this.sql = sql;
        this.option = option;
    }

    @Override
    public void run() {
        Connection connection = null;
        System.out.println("Executing: " + id);
        try {
            if (option == 1) {
                connection = DatabaseConnection.makeConnection();
            } else {
                connection = ConnectionPool.getConnection();
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery(sql);

            while(result.next()) {
                StringBuilder row = new StringBuilder();
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                    row.append(result.getString(i)).append(", ");
                }
                System.out.println(row);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}