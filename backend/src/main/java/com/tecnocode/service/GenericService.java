package com.tecnocode.service;

import com.tecnocode.validator.Operation;

public interface GenericService<T>{
    T save(T t, Operation operation);

    void delete(final Integer id);
}
