package com.ugromart.ordersms.order.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "order_item")
@Entity
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long productId;
    private int quantity;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order owningOrder;
    public OrderItem() {
    }

    public OrderItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }



    public long getProductId() {
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

    public Order getOwningOrder() {
        return owningOrder;
    }

    public void setOwningOrder(Order owningOrder) {
        this.owningOrder = owningOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
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
}
