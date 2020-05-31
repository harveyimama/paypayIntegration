package com.techland.paypay.intregration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.techland.paypay")
public class PayPayIntregrationApplication {
	public static void main(String[] args) {
		SpringApplication.run(PayPayIntregrationApplication.class, args);
	}

}
