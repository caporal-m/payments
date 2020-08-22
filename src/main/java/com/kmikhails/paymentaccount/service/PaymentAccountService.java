package com.kmikhails.paymentaccount.service;

import java.util.List;

import com.kmikhails.paymentaccount.model.PaymentAccount;
import org.springframework.data.domain.Sort;

public interface PaymentAccountService {

   PaymentAccount getPaymentAccountInfo(String mcUsername);
   
   PaymentAccount save(PaymentAccount paymentAccount);
   
   List<PaymentAccount> getListByStatus(String status, Sort sort);
}
