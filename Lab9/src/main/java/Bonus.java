import tables.MoviesEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.*;

public class Bonus {
    private List<MoviesEntity> playlist = new ArrayList<>();
    private Map<String, ArrayList<MoviesEntity>> relatedMovies = new HashMap<>();
    // director -> lista filmelor pe care le are

    public void solve() throws IOException {
        playlist.clear();
        makeRelatedMovies();

        Set<MoviesEntity> moviesInPlaylist = new HashSet<>(); // sa putem accesa in O(1) filmele ce sunt deja in playlist
        // iar in playlist pastram ordinea filmelor pe zile

        MoviesEntity movie1 = null, movie2 = null;
        int count;
        for(String director : relatedMovies.keySet()) {
            count = 0;

            for(MoviesEntity movie : relatedMovies.get(director)) {
                if(!moviesInPlaylist.contains(movie)) {
                    ++count;
                    if(count == 1) {
                        movie1 = movie;
                    } else if (count == 2) {
                        movie2 = movie;
                        break;
                    }
                }
            }

            if(count == 2) {
                moviesInPlaylist.addAll(Arrays.asList(movie1, movie2));
                playlist.addAll(Arrays.asList(movie1, movie2));
            }
        }
    }


    public void makeRelatedMovies() throws IOException {
        relatedMovies.clear();

        FileReader fileReader = new FileReader("D:\\Facultate\\MATERII\\An 2 Sem2\\3. PA\\IMDB\\IMDb movies.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine(); // scapam de capul de tabel
        int idMovie = 1;
        while ((line = bufferedReader.readLine()) != null /*&& idMovie < 100*/) {
            String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); // despartim in coloane

            String title = columns[1];
            int duration = Integer.parseInt(columns[6]);
            int score = (int) Float.parseFloat(columns[14]);

            MoviesEntity moviesEntity;
            try {
                Date releaseDate = Date.valueOf(columns[4]);
                moviesEntity = new MoviesEntity(idMovie++, title, releaseDate, duration, score);
            } catch (Exception e) {
                moviesEntity = new MoviesEntity(idMovie++, title, null, duration, score);
            }

            StringBuilder directorName = new StringBuilder();
            String[] directors = columns[9].split(", ");
            for (String director : directors) {
                String[] directorNames = director.split(" ");
                directorName.append(directorNames[directorNames.length - 1]).append(" ").append(directorNames[0]);
                // primul si ultimul nume
            }

            String director = directorName.toString();
            if (!relatedMovies.containsKey(director)) {
                relatedMovies.put(director, new ArrayList<>());
            }
            relatedMovies.get(director).add(moviesEntity);
        }
    }

    public void printPlaylist() {
        for(int i = 0; i < playlist.size(); i += 2) {
            System.out.println("Ziua " + (i / 2) + " -> " + playlist.get(i) + " " + playlist.get(i + 1));
        }
    }

    public List<MoviesEntity> getPlaylist() {
        return playlist;
    }


    public void setPlaylist(List<MoviesEntity> playlist) {
        this.playlist = playlist;
    }

    public Map<String, ArrayList<MoviesEntity>> getRelatedMovies() {
        return relatedMovies;
    }

    public void setRelatedMovies(Map<String, ArrayList<MoviesEntity>> relatedMovies) {
        this.relatedMovies = relatedMovies;
    }
}
