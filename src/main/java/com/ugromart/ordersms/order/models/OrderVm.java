package com.ugromart.ordersms.order.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderVm {

    private long orderId;
    private long userId;
    private String orderDate;
    private Money totalOrder;
    private  String status;
    private List<OrderItemVm> orderItems;

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

    public Money getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Money totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItemVm> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemVm> orderItems) {
        this.orderItems = orderItems;
    }

    public Order convertToOrder() {
        Order order =new Order(this.orderId,this.userId,this.orderDate,this.totalOrder.getAmount(),this.status,new ArrayList<>());
        for(OrderItemVm ovm : this.orderItems){
            order.getOrderItems().add(ovm.convertToOrderItem());
        }
        return order;
    }
}
