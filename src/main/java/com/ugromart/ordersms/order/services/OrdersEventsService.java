package com.ugromart.ordersms.order.services;

import com.ugromart.ordersms.order.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrdersEventsService {
    private static final Logger log = LoggerFactory.getLogger(OrdersEventsService.class);

    @Autowired
    OrderEventsProcessor orderEventsProcessor;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    EmailService emailService;
    @StreamListener(OrderEventsProcessor.ORDER_RECEIVED)
    public void receiveOrder(OrderVm ordervm){
        log.info("Order with id : {} received for customer Id: {} worth {} on  {} ",ordervm.getOrderId(),ordervm.getUserId(), ordervm.getTotalOrder().getAmount(),ordervm.getOrderDate());

        Order _order=ordervm.convertToOrder();
        _order.setStatus(OrderStatus.PLACED.name());
        Order order=orderService.save(_order);
        order.getOrderItems().stream().map(oi->{
            oi.setOwningOrder(order);
            oi=orderItemService.save(oi);
            return oi;
        });

        orderEventsProcessor.ordersRequestingPayment().send(message(new PaymentRequestMessage(order.getUserId(),new Money(order.getTotalOrder()),order.getCustomerPhoneNumber(),order.getOrderId().toString(),OrderStatus.PLACED.name(),null,order.getCustomerEmail())));

    }
    @StreamListener(OrderEventsProcessor.ORDER_PAID)
    public void processOrderPaid(OrderPaymentAk orderPayment){
        log.info("Order with id : {}  for customer Id: {} payment completion received",orderPayment.getOrderId(),orderPayment.getCustomerId());
        orderService.updateOrderStatusAndPaymentId(UUID.fromString(orderPayment.getOrderId()),OrderStatus.PAYMENT_FAILED.name(),UUID.fromString(orderPayment.getPaymentReferenceId()));
        orderEventsProcessor.ordersSendForDelivery().send(message(orderPayment));
        try {
            String message=String.format("Order with id : %s  for customer Id: %d payment completion received, Order is being processed for delivery",orderPayment.getOrderId(),orderPayment.getCustomerId());
            emailService.sendSimpleMessage(orderPayment.getCustomerEmail(),"Ugromart: Order Payment Succcessfull",message);
        }catch (Exception ex){
            log.error("Mail send failed with error: "+ex.getMessage(),ex);
        }
    }

    @StreamListener(OrderEventsProcessor.ORDER_PAYMENT_DECLINED)
    public void processOrderDeclined(OrderPaymentAk orderPayment){
        log.info("Order with id : {}  for customer Id: {} payment rejection received",orderPayment.getOrderId(),orderPayment.getCustomerId());
        orderService.updateOrderStatus(UUID.fromString(orderPayment.getOrderId()),OrderStatus.PAYMENT_FAILED.name());
        try {
            String message=String.format("Order with id : %s  for customer Id: %d payment rejected",orderPayment.getOrderId(),orderPayment.getCustomerId());
            emailService.sendSimpleMessage(orderPayment.getCustomerEmail(),"Ugromart: Order Payment Failed",message);
        }catch (Exception ex){
            log.error("Mail send failed with error: "+ex.getMessage(),ex);
        }
    }



    private static final <T>  Message<T> message(T val){return MessageBuilder.withPayload(val).build();}


}
