package repositories;

import factories.MovieManagerFactory;
import tables.MoviesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MovieRepositoryFromAbstract extends AbstractRepository<MoviesEntity>{
    @Override
    public void create(MoviesEntity movie) {
        EntityManager entityManager = MovieManagerFactory.getInstance().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(movie);
        transaction.commit();
    }

    @Override
    public MoviesEntity findById(int id) {
        EntityManager entityManager = MovieManagerFactory.getInstance().createEntityManager();
        return entityManager.find(MoviesEntity.class, id);
    }

    @Override
    public List findByName(String name) {
        EntityManager entityManager = MovieManagerFactory.getInstance().createEntityManager();
        return entityManager.createNamedQuery("MoviesEntity.findByName")
                .setParameter("title", name)
                .getResultList();
    }
}
