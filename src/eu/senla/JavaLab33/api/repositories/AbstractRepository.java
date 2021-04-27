package eu.senla.JavaLab33.api.repositories;

import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface AbstractRepository <T extends BaseEntity>{

    long create(T entity);

    void delete(long entity) throws NoRecordException;

    void update(T entity);

    Optional<T> get(long id);

    List<T> getAll();
}
