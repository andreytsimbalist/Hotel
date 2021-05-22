package eu.senla.JavaLab33.api.data;

import eu.senla.JavaLab33.model.BaseEntity;

import java.util.List;

public interface AbstractDataStorage<T extends BaseEntity>{

    List<T> getEntities();

    void setEntities(List<T> entities);

    T create(T entity);

}
