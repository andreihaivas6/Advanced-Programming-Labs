package repositories;

import factories.AbstractFactory;
import tables.MoviesEntity;

import java.util.List;

public abstract class AbstractRepository <T>{
    public abstract void create(T object);
    public abstract MoviesEntity findById(int id);
    public abstract List findByName(String name);
}
