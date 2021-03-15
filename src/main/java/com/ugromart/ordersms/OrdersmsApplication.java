package com.ugromart.ordersms;

import com.ugromart.ordersms.order.services.OrderEventsProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderEventsProcessor.class)
@SpringBootApplication
public class OrdersmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersmsApplication.class, args);
	}

}
