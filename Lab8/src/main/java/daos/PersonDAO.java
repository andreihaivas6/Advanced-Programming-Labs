package daos;

import others.DatabaseConnection;
import tables.Actor;
import tables.Director;
import tables.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {
    private Connection conn = DatabaseConnection.makeConnection();

    public PersonDAO() throws SQLException { }

    public void insert(Person person) throws SQLException {
        String sql = "INSERT INTO PERSONS VALUES(?, ?, ?, ?);";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, person.getId());
        statement.setString(2, person.getNume());
        statement.setString(3, person.getPrenume());

        if(person instanceof Actor) {
            statement.setInt(4, 1);
        } else {
            statement.setInt(4, 2);
        }

        statement.execute();
    }

    public Person selectId (int id) throws SQLException {
        String sql = "SELECT * FROM persons WHERE id=?;";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        result.next();

        Person person;
        if(result.getInt("discriminant") == 1) {
            person = new Actor();
        } else {
            person = new Director();
        }

        person.setId(result.getInt("id"));
        person.setNume(result.getString("nume"));
        person.setPrenume(result.getString("prenume"));

        return person;
    }
}
