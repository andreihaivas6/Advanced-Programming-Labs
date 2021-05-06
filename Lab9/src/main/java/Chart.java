import tables.MoviesEntity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Chart {
    private String name;
    private Date creationDate;
    private List<MoviesEntity> movies = new ArrayList<>();

    public Chart(String name) {
        this.name = name;
        LocalDate currTime = LocalDate.now();
        creationDate = java.sql.Date.valueOf(currTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<MoviesEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MoviesEntity> movies) {
        this.movies = movies;
    }
}
