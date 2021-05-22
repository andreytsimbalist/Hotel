package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.BaseEntity;

import java.util.List;

public interface AbstractService<T extends BaseEntity> {

    Long create(T entity);

    void delete(Long id) throws NoRecordException;

    void update(T entity);

    T get(Long id) throws NoRecordException;

    List<T> getAll();

}
