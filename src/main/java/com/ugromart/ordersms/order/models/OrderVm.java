package com.ugromart.ordersms.order.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderVm {

    private String orderId;
    private long userId;
    private String orderDate;
    private Money totalOrder;
    private  String status;
    private String customerPhoneNumber;
    private String customerEmail;
    private String customerName;
    private List<OrderItemVm> orderItems;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderItems(List<OrderItemVm> orderItems) {
        this.orderItems = orderItems;
    }

    public Order convertToOrder() {
        Order order =new Order(UUID.fromString(this.orderId),this.userId,this.orderDate,this.totalOrder.getAmount(),this.status,new ArrayList<>(),this.customerPhoneNumber,this.customerEmail,this.customerName);
        for(OrderItemVm ovm : this.orderItems){
            order.getOrderItems().add(ovm.convertToOrderItem());
        }
        return order;
    }
}
