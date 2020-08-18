package com.kmikhails.paymentaccount.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmikhails.paymentaccount.model.PaymentAccount;
import com.kmikhails.paymentaccount.repository.PaymentAccountRepository;

@Service
public class PaymentAccountServiceImpl implements PaymentAccountService {

   @Autowired
   private PaymentAccountRepository paymentAccountRepository;

   @Override
   public PaymentAccount getPaymentAccountInfo(String mcUsername) {
      return paymentAccountRepository.findById(mcUsername).orElseThrow(NoSuchElementException::new);
   }
   
   @Override
   public void save(PaymentAccount paymentAccount) {
      paymentAccountRepository.save(paymentAccount);
   }
}
