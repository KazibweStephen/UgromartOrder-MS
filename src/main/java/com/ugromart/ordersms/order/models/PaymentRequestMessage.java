package com.ugromart.ordersms.order.models;

public class PaymentRequestMessage {
    private long customerId;
    private Money totalOrder;
    private String customerPhoneNumber;
    private String orderId;
    private String status;
    private String paymentReferenceId;
    private  String customerEmail;


    public PaymentRequestMessage() {
    }

    public PaymentRequestMessage(String orderId, long customerId, Money totalOrder, String customerPhoneNumber, String status) {
        this.customerId = customerId;
        this.totalOrder = totalOrder;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderId = orderId;
        this.status=status;
    }

    public PaymentRequestMessage(long customerId, Money totalOrder, String customerPhoneNumber, String orderId, String status, String paymentReferenceId) {
        this.customerId = customerId;
        this.totalOrder = totalOrder;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderId = orderId;
        this.status = status;
        this.paymentReferenceId = paymentReferenceId;
    }

    public PaymentRequestMessage(long customerId, Money totalOrder, String customerPhoneNumber, String orderId, String status, String paymentReferenceId, String customerEmail) {
        this.customerId = customerId;
        this.totalOrder = totalOrder;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderId = orderId;
        this.status = status;
        this.paymentReferenceId = paymentReferenceId;
        this.customerEmail = customerEmail;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Money getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Money totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentReferenceId() {
        return paymentReferenceId;
    }

    public void setPaymentReferenceId(String paymentReferenceId) {
        this.paymentReferenceId = paymentReferenceId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
