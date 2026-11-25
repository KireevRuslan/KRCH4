package com.example.learningManagementSystem.service;

public interface UpdatableEntity<T> {
    void updateFrom(T sourse);
}
