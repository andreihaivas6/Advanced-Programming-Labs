import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

public class Import {
    public Import() throws SQLException { }

    public void importAll() throws SQLException, IOException, ParseException {
        MovieDAO movieDAO = new MovieDAO();
        GenreDAO genreDAO = new GenreDAO();
        MovieGenreDAO movieGenreDAO = new MovieGenreDAO();
        PersonDAO personDAO = new PersonDAO();

        FileReader fileReader = new FileReader("D:\\Facultate\\MATERII\\An 2 Sem2\\3. PA\\IMDB\\IMDb movies.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine(); // scapam de capul de tabel
        int idMovie = 1, idGenre = 1, idPerson = 1;
        while((line = bufferedReader.readLine()) != null && idMovie < 100) {
            String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // despartim in coloane

            String title = columns[1];
            int duration = Integer.parseInt(columns[6]);
            int score = (int)Float.parseFloat(columns[14]);

            try {
                Date releaseDate = Date.valueOf(columns[4]);
                movieDAO.insert(idMovie++, title, releaseDate, duration, score);
            } catch (Exception e) {
                movieDAO.insert(idMovie++, title, null, duration, score);
            }

            String[] genres = columns[5].split(", ");
            for(String name : genres) {
                try {
                    String nameAux = name.replaceAll("\"", "");
                    genreDAO.insert(idGenre, nameAux);
                    idGenre++;
                    movieGenreDAO.insert(idMovie - 1, idGenre - 1);
                } catch (Exception ignored) { } // daca exista nu mai inseram
            }

            String[] directors = columns[9].split(", ");
            for(String director : directors) {
                String[] directorNames = director.split(" ");
                personDAO.insert(new Director(idPerson++, directorNames[directorNames.length - 1] , directorNames[0]));
                // primul si ultimul nume
            }

            String[] actors = columns[12].split(", ");
            for(String actor : actors) {
                String[] actorNames = actor.split(" ");
                personDAO.insert(new Actor(idPerson++, actorNames[actorNames.length - 1] , actorNames[0]));
            }
        }
    }
}
