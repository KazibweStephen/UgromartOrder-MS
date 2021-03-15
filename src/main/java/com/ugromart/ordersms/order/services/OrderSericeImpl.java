package com.ugromart.ordersms.order.services;

import com.ugromart.ordersms.order.models.Order;
import com.ugromart.ordersms.order.repository.OrderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderSericeImpl implements OrderService {
    @Autowired
    private OrderRespository orderRespository;
    @Override
    public Order save(Order order) {
        return orderRespository.save(order);
    }

    @Override
    public Order findOrderById(long id) {
        return orderRespository.findById(id).get();
    }

    @Override
    public List<Order> findOrdersByUserId(long id) {
        return orderRespository.findOrdersByUserId(id).get();
    }

    @Override
    public List<Order> findAll() {
        return orderRespository.findAll();
    }

    @Override
    public void updateOrderStatus(long id, String status) {
       orderRespository.updateOrderStatus(id,status);
    }
}
