import tables.MoviesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Date;
import java.util.List;

public class MovieRepository {

    public void create(int id, String title, Date releaseDate, int duration, int score) {
        EntityManager entityManager = MovieManagerFactory.getInstance().createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        MoviesEntity movie = new MoviesEntity(id, title, releaseDate, duration, score);
        entityManager.persist(movie);

        transaction.commit();
    }

    public MoviesEntity findById(int id) {
        EntityManager entityManager = MovieManagerFactory.getInstance().createEntityManager();
        return entityManager.find(MoviesEntity.class, id);
    }

    public List findByName(String name){
        EntityManager entityManager = MovieManagerFactory.getInstance().createEntityManager();

        return entityManager.createNamedQuery("MoviesEntity.findByName")
                .setParameter("title", name)
                .getResultList();
    }
}
