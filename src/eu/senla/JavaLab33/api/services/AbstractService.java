package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.BaseEntity;

import java.util.List;

public interface AbstractService <T extends BaseEntity>{

    long create(T entity);

    void delete(long id) throws NoRecordException;

    void update(T entity);

    T get(long id) throws NoRecordException;

    List<T> getAll();
}
