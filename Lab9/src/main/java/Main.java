import factories.AbstractFactory;
import factories.DAOFactory;
import factories.RepositoryFactory;
import repositories.MovieRepositoryFromAbstract;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Scanner scanner = new Scanner(new File("input.txt"));
        String type = scanner.nextLine(); // JPA/JDBC
        scanner.close();

        AbstractFactory abstractFactory = null;
        if (type.equals("JPA")) {
            abstractFactory = new RepositoryFactory();
        } else if (type.equals("JDBC")) {
            abstractFactory = new DAOFactory();
        } else {
            System.out.println("Input fisier gresit.");
            System.exit(1);
        }

        Object movieManager = abstractFactory.getMovieManager();
        System.out.println(((MovieRepositoryFromAbstract) movieManager).findById(1));

//        MovieRepository movieRepository = new MovieRepository();
//        movieRepository.create(1, "NUme film", new Date(2000, 6, 6), 100, 5);
//        movieRepository.create(2, "NUme film", new Date(2001, 7, 7), 200, 4);
    }
}
