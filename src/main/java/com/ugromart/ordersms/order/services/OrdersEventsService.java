package com.ugromart.ordersms.order.services;

import com.ugromart.ordersms.order.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrdersEventsService {
    private static final Logger log = LoggerFactory.getLogger(OrdersEventsService.class);

    @Autowired
    OrderEventsProcessor orderEventsProcessor;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @StreamListener(OrderEventsProcessor.ORDER_RECEIVED)
    public void receiveOrder(OrderVm ordervm){
        log.info("Order with id : {} received for customer Id: {} worth {} on  {} ",ordervm.getOrderId(),ordervm.getUserId(), ordervm.getTotalOrder().getAmount(),ordervm.getOrderDate());
       //TO DO:
        //save the order
        Order order=orderService.save((ordervm.convertToOrder()));
        order.getOrderItems().stream().map(oi->{
            oi.setOwningOrder(order);
            oi=orderItemService.save(oi);
            return oi;
        });

        orderEventsProcessor.ordersRequestingPayment().send(message(new PaymentRequestMessage(order.getUserId(),new Money(order.getTotalOrder()))));

    }
    @StreamListener(OrderEventsProcessor.ORDER_PAID)
    public void processOrderPaid(OrderPaymentAk orderPayment){
        orderService.updateOrderStatus(orderPayment.getCustomerId(),OrderStatus.PAYMENT_PROCESSED.name());
        orderEventsProcessor.ordersSendForDelivery().send(message(orderPayment));
    }

    @StreamListener(OrderEventsProcessor.ORDERS_CREATED_OUT_FOR_PAYMENT)
    public void processOrderDeclined(OrderPaymentAk orderPayment){
        orderService.updateOrderStatus(orderPayment.getCustomerId(),OrderStatus.PAYMENT_FAILED.name());
        //TO DO:
        //Email service must be trigered to customer
    }



    private static final <T>  Message<T> message(T val){return MessageBuilder.withPayload(val).build();}


}
