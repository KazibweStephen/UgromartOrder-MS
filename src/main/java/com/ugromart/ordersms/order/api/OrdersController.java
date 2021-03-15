package com.ugromart.ordersms.order.api;

import com.ugromart.ordersms.order.models.Order;
import com.ugromart.ordersms.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordersms/order")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getOrders(){
        List<Order> orders= orderService.findAll();
        return  ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable("customerId") long customerId){
        List<Order> orders= orderService.findOrdersByUserId(customerId);
        return  ResponseEntity.ok().body(orders);
    }
}
