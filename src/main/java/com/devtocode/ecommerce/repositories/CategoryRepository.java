package com.devtocode.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devtocode.ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
