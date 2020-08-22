package com.kmikhails.paymentaccount.dto;

import java.time.LocalDateTime;

import com.kmikhails.paymentaccount.model.PaymentAccount;

public class PaymentAccountDto {
   private  String mcUsername;
   private  LocalDateTime changeDate;
   private  String contractorFirstName;
   private  String contractorInn;
   private  String contractorLastName;
   private  String contractorPhone;
   private  String contractorSecondName;
   private  String errorCode;
   private  String errorMessage;
   private  String requestId;
   private  String status;
   
   public PaymentAccountDto() {
      
   }
   
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

   public void setMcUsername(String mcUsername) {
      this.mcUsername = mcUsername;
   }

   public LocalDateTime getChangeDate() {
      return changeDate;
   }

   public void setChangeDate(LocalDateTime changeDate) {
      this.changeDate = changeDate;
   }

   public String getContractorFirstName() {
      return contractorFirstName;
   }

   public void setContractorFirstName(String contractorFirstName) {
      this.contractorFirstName = contractorFirstName;
   }

   public String getContractorInn() {
      return contractorInn;
   }

   public void setContractorInn(String contractorInn) {
      this.contractorInn = contractorInn;
   }

   public String getContractorLastName() {
      return contractorLastName;
   }

   public void setContractorLastName(String contractorLastName) {
      this.contractorLastName = contractorLastName;
   }

   public String getContractorPhone() {
      return contractorPhone;
   }

   public void setContractorPhone(String contractorPhone) {
      this.contractorPhone = contractorPhone;
   }

   public String getContractorSecondName() {
      return contractorSecondName;
   }

   public void setContractorSecondName(String contractorSecondName) {
      this.contractorSecondName = contractorSecondName;
   }

   public String getErrorCode() {
      return errorCode;
   }

   public void setErrorCode(String errorCode) {
      this.errorCode = errorCode;
   }

   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   public String getRequestId() {
      return requestId;
   }

   public void setRequestId(String requestId) {
      this.requestId = requestId;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public static PaymentAccountDto fromPaymentAccount(PaymentAccount paymentAccount) {
      PaymentAccountDto paymentAccountDto = new PaymentAccountDto();
      
      paymentAccountDto.setMcUsername(paymentAccount.getMcUsername());
      paymentAccountDto.setChangeDate(paymentAccount.getChangeDate());
      paymentAccountDto.setContractorFirstName(paymentAccount.getContractorFirstName());
      paymentAccountDto.setContractorInn(paymentAccount.getContractorInn());
      paymentAccountDto.setContractorLastName(paymentAccount.getContractorLastName());
      paymentAccountDto.setContractorPhone(paymentAccount.getContractorPhone());
      paymentAccountDto.setContractorSecondName(paymentAccount.getContractorSecondName());
      paymentAccountDto.setErrorCode(paymentAccount.getErrorCode());
      paymentAccountDto.setErrorMessage(paymentAccount.getErrorMessage());
      paymentAccountDto.setRequestId(paymentAccount.getRequestId());
      paymentAccountDto.setStatus(paymentAccount.getStatus());
      
      return paymentAccountDto;
   }
   
   public static PaymentAccount toPaymentAccount(PaymentAccountDto paymentAccountDto) {
      PaymentAccount paymentAccount = new PaymentAccount();
      
      paymentAccount.setMcUsername(paymentAccountDto.getMcUsername());
      paymentAccount.setChangeDate(paymentAccountDto.getChangeDate());
      paymentAccount.setContractorFirstName(paymentAccountDto.getContractorFirstName());
      paymentAccount.setContractorInn(paymentAccountDto.getContractorInn());
      paymentAccount.setContractorLastName(paymentAccountDto.getContractorLastName());
      paymentAccount.setContractorPhone(paymentAccountDto.getContractorPhone());
      paymentAccount.setContractorSecondName(paymentAccountDto.getContractorSecondName());
      paymentAccount.setErrorCode(paymentAccountDto.getErrorCode());
      paymentAccount.setErrorMessage(paymentAccountDto.getErrorMessage());
      paymentAccount.setRequestId(paymentAccountDto.getRequestId());
      paymentAccount.setStatus(paymentAccountDto.getStatus());
      
      return paymentAccount;
   }
}
