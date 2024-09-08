package com.devtocode.ecommerce.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devtocode.ecommerce.entities.User;
import com.devtocode.ecommerce.repositories.UserRepository;

@Configuration
@Profile("test")
public class ConfigTestUserDB implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		User user1 = new User(null, "Luis Soares", "luissoares@outlook.com", "71983673280","casa123");
		User user2 = new User(null, "Gerson Coelho", "gerson_coelho@live.com", "71987749903","casa12345");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
	}
	
}
