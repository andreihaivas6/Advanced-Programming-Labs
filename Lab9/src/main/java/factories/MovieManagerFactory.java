package factories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovieManagerFactory {
    private static EntityManagerFactory entityManagerFactory = null;

    private MovieManagerFactory() { }

    public static EntityManagerFactory getInstance() {
        if(entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
        }
        return entityManagerFactory;
    }
}
