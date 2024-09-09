package com.devtocode.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devtocode.ecommerce.entities.OrderItem;
import com.devtocode.ecommerce.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
