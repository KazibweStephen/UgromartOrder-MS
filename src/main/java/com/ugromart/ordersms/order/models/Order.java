package com.ugromart.ordersms.order.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "order_table")
@Entity
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private long userId;
    private String orderDate;
    private BigDecimal totalOrder;
    private  String status;
    @JsonManagedReference
    @OneToMany(mappedBy = "owningOrder")

    private List<OrderItem> orderItems;
    public Order() {
    }

    public Order(long orderId, long userId, String orderDate, BigDecimal totalOrder, String status, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalOrder = totalOrder;
        this.status = status;
        this.orderItems = orderItems;
    }



    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(BigDecimal totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
