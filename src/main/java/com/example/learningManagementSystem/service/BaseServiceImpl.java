package com.example.learningManagementSystem.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected final JpaRepository<T, Long> repository;

    protected BaseServiceImpl(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("entity not found"));
    }

    public List<T> getAll(){
        return repository.findAll();
    }

    public T create(T t){
        return repository.save(t);
    }

    public T update(Long id, T t) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("entity not found");
        }
        return repository.save(t);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("entity not found");
        }
        repository.deleteById(id);
    }
}
