package com.example.learningManagementSystem.service;

import com.example.learningManagementSystem.entity.Student;

import java.util.List;

public interface BaseService<T> {
    T getById(Long id);


    T create(T t);


    List<T> getAll();

    T update(Long id, T t);


    void deleteById(Long id);

}
