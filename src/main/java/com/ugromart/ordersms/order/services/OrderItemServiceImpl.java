package com.ugromart.ordersms.order.services;

import com.ugromart.ordersms.order.models.OrderItem;
import com.ugromart.ordersms.order.repository.OrderItemRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemRespository orderItemRespository;
    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRespository.save(orderItem);
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRespository.findAll();
    }
}
