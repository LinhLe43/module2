package com.example.studentmanager.service;

import java.util.List;

public interface IService<E> {
    void add(E e);
    void edit(int id, E e);
    void delete(int id);
    List<E> findAll();
    int findById(int id);
}
