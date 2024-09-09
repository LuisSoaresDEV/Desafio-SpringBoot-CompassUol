package com.devtocode.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtocode.ecommerce.entities.Category;
import com.devtocode.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category insert(Category obj) {
        return repository.save(obj);
    }

    public Category update(Long id, Category obj) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        obj.setId(id);
        return repository.save(obj);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        repository.deleteById(id);
    }
}
