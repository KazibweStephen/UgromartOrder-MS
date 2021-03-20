package com.ugromart.ordersms;

import com.ugromart.ordersms.order.services.OrderEventsProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@EnableBinding(OrderEventsProcessor.class)
@SpringBootApplication
public class OrdersmsApplication {

	@Value("${spring.mail.username}")
	private String gmailUsername;
	@Value("${spring.mail.password}")
	private String gmailPassword;
	@Value("${spring.mail.host}")
	private String gmailServerHost;
	@Value("${spring.mail.port}")
	private int gmailServerPort;

	public static void main(String[] args) {
		SpringApplication.run(OrdersmsApplication.class, args);
	}


	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(gmailServerHost);
		mailSender.setPort(gmailServerPort);

		mailSender.setUsername(gmailUsername);
		mailSender.setPassword(gmailPassword);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

}
