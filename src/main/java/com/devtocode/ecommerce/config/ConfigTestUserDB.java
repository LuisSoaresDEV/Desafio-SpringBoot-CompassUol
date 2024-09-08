package com.devtocode.ecommerce.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devtocode.ecommerce.entities.Order;
import com.devtocode.ecommerce.entities.User;
import com.devtocode.ecommerce.repositories.OrderRepository;
import com.devtocode.ecommerce.repositories.UserRepository;

@Configuration
@Profile("test")
public class ConfigTestUserDB implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository OrderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		User u1 = new User(null, "Luis Soares", "luissoares@outlook.com", "71983673280","casa123");
		User u2= new User(null, "Gerson Coelho", "gerson_coelho@live.com", "71987749903","casa12345");
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		OrderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
	}
	
}
