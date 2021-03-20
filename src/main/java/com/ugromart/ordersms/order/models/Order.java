package com.ugromart.ordersms.order.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Table(name = "order_table")
@Entity
public class Order implements Serializable {
    @Id
    private UUID orderId;
    private long userId;
    private String orderDate;
    private BigDecimal totalOrder;
    private  String status;
    private String customerPhoneNumber;
    private String customerEmail;
    private String customerName;
    private UUID paymentReferenceId;


    @JsonManagedReference
    @OneToMany(mappedBy = "owningOrder")

    private List<OrderItem> orderItems;
    public Order() {
    }

    public Order(UUID orderId, long userId, String orderDate, BigDecimal totalOrder, String status, List<OrderItem> orderItems, String customerPhoneNumber, String customerEmail, String customerName) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalOrder = totalOrder;
        this.status = status;
        this.orderItems = orderItems;
        this.customerPhoneNumber=customerPhoneNumber;
        this.customerEmail=customerPhoneNumber;
        this.customerName=customerPhoneNumber;
    }

    public Order(UUID orderId, long userId, String orderDate, BigDecimal totalOrder, String status, String customerPhoneNumber, String customerEmail, String customerName, UUID paymentReferenceId, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.totalOrder = totalOrder;
        this.status = status;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.paymentReferenceId = paymentReferenceId;
        this.orderItems = orderItems;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
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

    public UUID getPaymentReferenceId() {
        return paymentReferenceId;
    }

    public void setPaymentReferenceId(UUID paymentReferenceId) {
        this.paymentReferenceId = paymentReferenceId;
    }
}
