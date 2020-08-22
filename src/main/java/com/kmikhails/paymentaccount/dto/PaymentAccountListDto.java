package com.kmikhails.paymentaccount.dto;

import java.util.List;

import com.kmikhails.paymentaccount.model.PaymentAccount;

public class PaymentAccountListDto {
   private final List<PaymentAccount> paymentAccounts;

   public PaymentAccountListDto(List<PaymentAccount> paymentAccounts) {
      this.paymentAccounts = paymentAccounts;
   }

   public List<PaymentAccount> getPaymentAccounts() {
      return paymentAccounts;
   }
}
