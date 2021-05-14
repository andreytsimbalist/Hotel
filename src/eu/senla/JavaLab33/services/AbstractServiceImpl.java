package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.AbstractRepository;
import eu.senla.JavaLab33.api.services.AbstractService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractServiceImpl <T extends BaseEntity> implements AbstractService<T> {

    @Autowired
    protected AbstractRepository<T> abstractRepository;

    @Override
    public long create(T entity) {
        return abstractRepository.create(entity);
    }

    @Override
    public void delete(long id) throws NoRecordException {
        abstractRepository.delete(id);
    }

    @Override
    public void update(T entity) {
        abstractRepository.update(entity);
    }

    @Override
    public T get(long id) throws NoRecordException {
        return abstractRepository.get(id).orElseThrow(NoRecordException::new);
    }

    @Override
    public List<T> getAll() {
        return abstractRepository.getAll();
    }

    @Override
    public void displayInfo(long id) {
        abstractRepository.get(id).ifPresent(System.out::println);
    }

    @Override
    public List<T> sortByKey(Comparator<T> comparator) {
        return abstractRepository.getAll()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

}
