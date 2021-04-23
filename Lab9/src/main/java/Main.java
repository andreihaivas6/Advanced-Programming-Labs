import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        MovieRepository movieRepository = new MovieRepository();
//        movieRepository.create(1, "NUme film", new Date(2000, 6, 6), 100, 5);
//        movieRepository.create(2, "NUme film", new Date(2001, 7, 7), 200, 4);
        System.out.println(movieRepository.findById(1));
        System.out.println(movieRepository.findByName("NUme film"));
    }
}
