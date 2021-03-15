package com.ugromart.ordersms.order.models;

import lombok.Data;

public class PaymentRequestMessage {
    public long customerId;
    public Money totalOrder;

    public PaymentRequestMessage() {
    }

    public PaymentRequestMessage(long customerId, Money totalOrder) {
        this.customerId = customerId;
        this.totalOrder = totalOrder;
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


}
