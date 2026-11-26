package com.example.learningManagementSystem.validator;

public interface DuplicateChecker<T> {
    void check(T entity);
    void checkForUpdate(T entity, Long id);
}
