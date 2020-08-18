package com.kmikhails.paymentaccount.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmikhails.paymentaccount.model.PaymentAccount;
import com.kmikhails.paymentaccount.service.PaymentAccountService;

@RestController()
public class AccountController {
   
   @Autowired
   private PaymentAccountService paymentAccountService;

   @GetMapping("/account/info")
   public ResponseEntity<PaymentAccount> getPaymentAccountInfo(@RequestParam(value = "mcUsername") String mcUsername) {
      try {
         PaymentAccount paymentAccount = paymentAccountService.getPaymentAccountInfo(mcUsername);
         return new ResponseEntity<PaymentAccount>(paymentAccount, HttpStatus.OK);
     } catch (NoSuchElementException e) {
         return new ResponseEntity<PaymentAccount>(HttpStatus.NOT_FOUND);
     }  
   }
   
   @PostMapping("/account/add")
   public void addPaymentAccountInfo(@RequestBody PaymentAccount paymentAccount) {
      paymentAccountService.save(paymentAccount);
   }
   
   @PutMapping("/account/info")
   public ResponseEntity<PaymentAccount> updatePaymentAccountInfo(@RequestBody PaymentAccount paymentAccount,
         @RequestParam(value = "mcUsername") String mcUsername) {
      try {
         PaymentAccount existPaymentAccount = paymentAccountService.getPaymentAccountInfo(mcUsername);
         paymentAccountService.save(existPaymentAccount);
         return new ResponseEntity<PaymentAccount>(HttpStatus.OK);
     } catch (NoSuchElementException e) {
         return new ResponseEntity<PaymentAccount>(HttpStatus.NOT_FOUND);
     }      
   }
}
