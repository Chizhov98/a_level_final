package com.example.back_end.service;


import java.util.List;

public interface CrudService<E> {

    void create(E e);

    void update(E e);

    void delete(Long id);

    E findById(Long id);

    List<E> findAll();
}