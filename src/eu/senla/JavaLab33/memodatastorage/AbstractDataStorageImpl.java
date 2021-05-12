package eu.senla.JavaLab33.memodatastorage;

import eu.senla.JavaLab33.api.data.AbstractDataStorage;
import eu.senla.JavaLab33.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AbstractDataStorageImpl<T extends BaseEntity> implements AbstractDataStorage<T> {

    private long entityIdSequence;

    private List<T> entities = new ArrayList<>();

    protected long generateEntityId() {
        return entityIdSequence++;
    }

    @Override
    public T create(T entity) {
        entity.setId(generateEntityId());
        entities.add(entity);
        return entity;
    }
}
