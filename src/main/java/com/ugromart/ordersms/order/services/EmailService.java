package com.ugromart.ordersms.order.services;

public interface EmailService {
    void sendSimpleMessage(String to, String subject,String text);
}
