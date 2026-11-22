package com.example.learningManagementSystem.controller;

import com.example.learningManagementSystem.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T> {
    protected final BaseService<T> service;

    protected BaseController(BaseService<T> service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<T> getAll() {
        return service.getAll();
    }

    @PostMapping
    public T create(@RequestBody T t) {
        return service.create(t);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable Long id, @RequestBody T t) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}