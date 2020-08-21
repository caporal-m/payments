package com.kmikhails.paymentaccount.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmikhails.paymentaccount.dto.PaymentAccountDto;
import com.kmikhails.paymentaccount.model.PaymentAccount;
import com.kmikhails.paymentaccount.service.PaymentAccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
   
   @Autowired
   private PaymentAccountService paymentAccountService;

   @GetMapping("/info")
   public ResponseEntity<PaymentAccountDto> getPaymentAccountInfo(@RequestParam(value = "mcUsername") String mcUsername) {
      try {
         PaymentAccount paymentAccount = paymentAccountService.getPaymentAccountInfo(mcUsername);
         
         return new ResponseEntity<>(PaymentAccountDto.fromPaymentAccount(paymentAccount), HttpStatus.OK);
     } catch (NoSuchElementException e) {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }  
   }
   
   @PostMapping("/add")
   public ResponseEntity<PaymentAccountDto> addPaymentAccountInfo(@RequestBody PaymentAccount paymentAccount) {
      return new ResponseEntity<>(PaymentAccountDto.fromPaymentAccount(paymentAccountService.save(paymentAccount)),
            HttpStatus.CREATED);
   }
   
   @PutMapping("/info")
   public ResponseEntity<PaymentAccountDto> updatePaymentAccountInfo(@RequestBody PaymentAccount paymentAccount,
         @RequestParam(value = "mcUsername") String mcUsername) {
      try {
         PaymentAccount existPaymentAccount = paymentAccountService.getPaymentAccountInfo(mcUsername);
         
         return new ResponseEntity<>(PaymentAccountDto.fromPaymentAccount(paymentAccountService.save(existPaymentAccount)),
               HttpStatus.OK);
     } catch (NoSuchElementException e) {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }      
   }
}
