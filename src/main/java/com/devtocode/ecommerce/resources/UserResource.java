package com.devtocode.ecommerce.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devtocode.ecommerce.entities.User;

@RestController
@RequestMapping(value ="/users")
public class UserResource {

		@GetMapping
		public ResponseEntity<User> searchUser(){
			
			User user = new User(1L, "Teste", "teste@gmail.com", "32154078", "32154078");
		
			
			return ResponseEntity.ok().body(user);
			
			
		

			
			
		}
	
	
	
	
}
