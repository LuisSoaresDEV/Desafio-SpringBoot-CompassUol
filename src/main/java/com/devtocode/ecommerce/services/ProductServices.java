package com.devtocode.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtocode.ecommerce.entities.Product;
import com.devtocode.ecommerce.repositories.ProductRepository;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public Product insert(Product obj) {
        return repository.save(obj);
    }

    public Product update(Long id, Product obj) {
        Product entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setDescripition(obj.getDescripition());
        entity.setPrice(obj.getPrice());
        entity.setImgUrl(obj.getImgUrl());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
