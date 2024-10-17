package ra.api.categy.service;

import ra.api.categy.entity.Department;

import java.util.List;
import java.util.Objects;

public interface IService<T, E> {
    List<T> findAll();

    T findById(E id);

    T save(T t);



    void delete(E id);
}
