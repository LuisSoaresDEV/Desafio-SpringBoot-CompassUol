package com.devtocode.ecommerce.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devtocode.ecommerce.entities.Category;
import com.devtocode.ecommerce.entities.Order;
import com.devtocode.ecommerce.entities.OrderItem;
import com.devtocode.ecommerce.entities.Product;
import com.devtocode.ecommerce.entities.User;
import com.devtocode.ecommerce.entities.enums.OrderStatus;
import com.devtocode.ecommerce.repositories.CategoryRepository;
import com.devtocode.ecommerce.repositories.OrderItemRepository;
import com.devtocode.ecommerce.repositories.OrderRepository;
import com.devtocode.ecommerce.repositories.ProductRepository;
import com.devtocode.ecommerce.repositories.UserRepository;

@Configuration
@Profile("test")
public class ConfigTestUserDB implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository OrderRepository;
	
	
	@Autowired
	private CategoryRepository CategoryRepository;
	
	@Autowired
	private ProductRepository ProductRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		// Instanciando as categorias
		Category category1 = new Category(null, "Smartphones");
		Category category2 = new Category(null, "Electronics");
		Category category3 = new Category(null, "Tools");
		
		
		//instanciando os produtos
		Product p1 = new Product(null, "Galaxy Pro Max 5G", "High-capacity portable charger with two USB ports,", 999.99,"");
		Product p2 = new Product(null, "AlphaSound Wireless Earbuds", "Premium Bluetooth earbuds with noise cancellation, 20-hour battery life, and IPX5 water resistance. Ideal for on-the-go listening.", 149.99, "");
		Product p3 = new Product(null, "XtremePower Portable Power Bank", "High-capacity portable charger with two USB ports, capable of charging smartphones, tablets, and laptops. Compact and lightweight.", 59.99, "");
		Product p4 = new Product(null, "PrecisionPro Cordless Drill 18V", "A powerful cordless drill with 18V motor, variable speed, and a built-in LED light for precision work. Includes two rechargeable batteries.", 1200.0, "");
		Product p5 = new Product(null, "MasterGrip 52-Piece Tool Set", "Comprehensive tool set with high-quality wrenches, screwdrivers, and pliers. Perfect for both home repairs and professional use.", 89.99, ""); 

		CategoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		ProductRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		
		p1.getCategories().add(category1);
		p2.getCategories().add(category2);
		p3.getCategories().add(category2);
		p4.getCategories().add(category3);
		p5.getCategories().add(category3);
		
		ProductRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		// Instanciando os usuários
		User u1 = new User(null, "Luis Soares", "luissoares@outlook.com", "71983673280","casa123");
		User u2= new User(null, "Gerson Coelho", "gerson_coelho@live.com", "71987749903","casa12345");
		
		// Instanciando os pedidos com status
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CACELLED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		OrderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}
	
	
	
	
	
}
