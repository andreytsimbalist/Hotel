package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.AbstractRepository;
import eu.senla.JavaLab33.api.services.AbstractService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractServiceImpl<T extends BaseEntity> implements AbstractService<T> {

    @Autowired
    private AbstractRepository<T> abstractRepository;

    @Override
    public Long create(T entity) {
        return abstractRepository.save(entity).getId();
    }

    @Override
    public void delete(Long id) throws NoRecordException {
        abstractRepository.deleteById(id);
    }

    @Override
    public void update(T entity) {
        abstractRepository.save(entity);
    }

    @Override
    public T get(Long id) throws NoRecordException {
        return abstractRepository.findById(id).orElseThrow(NoRecordException::new);
    }

    @Override
    public List<T> getAll() {
        return (List<T>) abstractRepository.findAll();
    }

}