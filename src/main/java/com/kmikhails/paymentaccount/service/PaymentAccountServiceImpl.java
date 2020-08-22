package com.kmikhails.paymentaccount.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

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
   public PaymentAccount save(PaymentAccount paymentAccount) {
      return paymentAccountRepository.save(paymentAccount);
   }
   
   @Override
   public List<PaymentAccount> getListByStatus(String status, Sort sort) {
      return paymentAccountRepository.findAllByStatus(status, sort);
   }
}
