package eu.senla.JavaLab33.api.repositories;

import eu.senla.JavaLab33.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;

public interface AbstractRepository<T extends BaseEntity> extends CrudRepository<T, Long> {
}