package service;

import java.util.List;

public interface ProductService<E> {
    void add(E e);
    void edit(int id, E e);
    void delete(int id);
    List<E> findAll();

    E getById(int id);
}
