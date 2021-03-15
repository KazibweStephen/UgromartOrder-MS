package com.ugromart.ordersms.order.models;

import java.util.Objects;

public class OrderItemVm {
    private int productId;
    private int quantity;

    public OrderItemVm() {
    }

    public OrderItemVm(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemVm orderItem = (OrderItemVm) o;
        return productId == orderItem.productId &&
                quantity == orderItem.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }

    public OrderItem convertToOrderItem() {
        return new OrderItem(this.productId,this.quantity);
    }
}
