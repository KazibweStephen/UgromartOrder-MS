package com.ugromart.ordersms.order.repository;

import com.ugromart.ordersms.order.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRespository extends JpaRepository<OrderItem,Long> {
}
