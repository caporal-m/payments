package com.kmikhails.paymentaccount.dto;

import java.time.LocalDateTime;

import com.kmikhails.paymentaccount.model.PaymentAccount;

public class PaymentAccountDto {
   private final String mcUsername;
   private final LocalDateTime changeDate;
   private final String contractorFirstName;
   private final String contractorInn;
   private final String contractorLastName;
   private final String contractorPhone;
   private final String contractorSecondName;
   private final String errorCode;
   private final String errorMessage;
   private final String requestId;
   private final String status;
   
   public PaymentAccountDto(String mcUsername, LocalDateTime changeDate, String contractorFirstName,
         String contractorInn, String contractorLastName, String contractorPhone, String contractorSecondName,
         String errorCode, String errorMessage, String requestId, String status) {
      this.mcUsername = mcUsername;
      this.changeDate = changeDate;
      this.contractorFirstName = contractorFirstName;
      this.contractorInn = contractorInn;
      this.contractorLastName = contractorLastName;
      this.contractorPhone = contractorPhone;
      this.contractorSecondName = contractorSecondName;
      this.errorCode = errorCode;
      this.errorMessage = errorMessage;
      this.requestId = requestId;
      this.status = status;
   }

   public String getMcUsername() {
      return mcUsername;
   }

   public LocalDateTime getChangeDate() {
      return changeDate;
   }

   public String getContractorFirstName() {
      return contractorFirstName;
   }

   public String getContractorInn() {
      return contractorInn;
   }

   public String getContractorLastName() {
      return contractorLastName;
   }

   public String getContractorPhone() {
      return contractorPhone;
   }

   public String getContractorSecondName() {
      return contractorSecondName;
   }

   public String getErrorCode() {
      return errorCode;
   }

   public String getErrorMessage() {
      return errorMessage;
   }

   public String getRequestId() {
      return requestId;
   }

   public String getStatus() {
      return status;
   }

   public static PaymentAccountDto fromPaymentAccount(PaymentAccount paymentAccount) {
      return new PaymentAccountDto(paymentAccount.getMcUsername(), paymentAccount.getChangeDate(), paymentAccount.getContractorFirstName(),
            paymentAccount.getContractorInn(), paymentAccount.getContractorLastName(), paymentAccount.getContractorPhone(),
            paymentAccount.getContractorSecondName(), paymentAccount.getErrorCode(), paymentAccount.getErrorMessage(),
            paymentAccount.getRequestId(), paymentAccount.getStatus());
   }
}
