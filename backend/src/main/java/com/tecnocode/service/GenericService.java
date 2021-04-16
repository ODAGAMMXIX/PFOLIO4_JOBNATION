package com.tecnocode.service;

public interface GenericService<T>{
    T save(T t);

    void delete(final Integer id);
}
