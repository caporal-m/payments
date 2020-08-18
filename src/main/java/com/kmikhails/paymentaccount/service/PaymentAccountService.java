package com.kmikhails.paymentaccount.service;

import com.kmikhails.paymentaccount.model.PaymentAccount;

public interface PaymentAccountService {

   PaymentAccount getPaymentAccountInfo(String mcUsername);
   
   void save(PaymentAccount paymentAccount);
}
