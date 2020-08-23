package com.kmikhails.paymentaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PaymentAccountApp {
   
   public static void main(String[] args) {
      SpringApplication.run(PaymentAccountApp.class, args);
   }
}
