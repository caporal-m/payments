package com.kmikhails.paymentaccount.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paymentAccounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentAccounts {
   
   @XmlElement(name = "paymentAccount")
   private List<PaymentAccount> paymentAccounts;

   public List<PaymentAccount> getPaymentAccounts() {
      return paymentAccounts;
   }

   public void setPaymentAccounts(List<PaymentAccount> paymentAccounts) {
      this.paymentAccounts = paymentAccounts;
   }
}
