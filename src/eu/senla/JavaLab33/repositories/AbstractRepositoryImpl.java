package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.api.repositories.AbstractRepository;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.api.data.AbstractDataStorage;
import eu.senla.JavaLab33.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public class AbstractRepositoryImpl <T extends BaseEntity> implements AbstractRepository<T> {

    protected AbstractDataStorage<T> abstractDataStorage;

    @Override
    public long create(T entity) {
        return abstractDataStorage.create(entity).getId();
    }

    @Override
    public void delete(long id) throws NoRecordException {
        T entityToDelete = abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElseThrow(NoRecordException::new);

        abstractDataStorage.getEntities().remove(entityToDelete);
    }

    @Override
    public void update(T entity) {
        int index = abstractDataStorage.getEntities().indexOf(entity);
        abstractDataStorage.getEntities().set(index, entity);
    }

    @Override
    public Optional<T> get(long id) {
        return abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst();
    }

    @Override
    public List<T> getAll() {
        return abstractDataStorage.getEntities();
    }
}
