package com.ugromart.ordersms.order.services;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface OrderEventsProcessor {
    String ORDER_RECEIVED="orders_in";
    String ORDERS_CREATED_OUT_FOR_PAYMENT="order_out_for_payment";
    String ORDER_PAID="order_payment_successful";
    String ORDER_PAYMENT_DECLINED="order_payment_declined_rejected";
    String ORDER_OUT_FOR_DELIVERY="orders_out_for_deivery";

    @Input(ORDER_RECEIVED)
    SubscribableChannel ordersReceived();

    @Input(ORDER_PAID)
    SubscribableChannel ordersPaid();

    @Input(ORDER_PAYMENT_DECLINED)
    SubscribableChannel ordersPaymentDeclined();

    @Output(ORDERS_CREATED_OUT_FOR_PAYMENT)
    MessageChannel ordersRequestingPayment();

    @Output(ORDER_OUT_FOR_DELIVERY)
    MessageChannel ordersSendForDelivery();


}
