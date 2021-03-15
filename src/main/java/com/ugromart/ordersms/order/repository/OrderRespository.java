package com.ugromart.ordersms.order.repository;

import com.ugromart.ordersms.order.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface OrderRespository extends JpaRepository<Order,Long> {
    @Query(value = "SELECT o FROM Order o WHERE userId=?1 ")
    Optional<List<Order>> findOrdersByUserId(long id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE Order o SET o.status = ?2 where o.id = ?1")
    void  updateOrderStatus(long id , String status);
}
