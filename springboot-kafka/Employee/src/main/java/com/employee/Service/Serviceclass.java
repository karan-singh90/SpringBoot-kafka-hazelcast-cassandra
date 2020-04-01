package com.employee.Service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Serviceclass<T> {
    boolean add(T object);
    T get(String id);
    void remove(String id);
    void update(T object);
    List<T> getAll();
}
