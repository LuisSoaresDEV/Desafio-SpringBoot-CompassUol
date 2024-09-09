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
	
	public List<Product> findAll(){
		
		
		return repository.findAll();
	}
	
	
	public Product findById(Long id) {
		
		
		Optional<Product> obj =repository.findById(id);
		
		return obj.get();
		
	}
	
	
	
	
	
	

}
