package com.devtocode.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devtocode.ecommerce.entities.Category;
import com.devtocode.ecommerce.entities.User;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
