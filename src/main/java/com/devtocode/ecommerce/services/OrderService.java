package com.devtocode.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtocode.ecommerce.entities.Order;
import com.devtocode.ecommerce.repositories.OrderRepository;


@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		
		
		return repository.findAll();
	}
	
	
	public Order findById(Long id) {
		
		
		Optional<Order> obj = repository.findById(id);
		
		return obj.get();
		
	}
	
	
	
	
	
	

}
