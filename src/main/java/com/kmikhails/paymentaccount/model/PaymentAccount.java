package com.kmikhails.paymentaccount.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_account")
public class PaymentAccount {

   @Id
   private String mcUsername;
   
   private LocalDateTime changeDate;

   private String contractorFirstName;

   private String contractorInn;

   private String contractorLastName;

   private String contractorPhone;

   private String contractorSecondName;

   private String errorCode;

   private String errorMessage;

   private String requestId;

   private String status;
   
   public PaymentAccount() {
      
   }
   
   public PaymentAccount(String mcUsername, LocalDateTime changeDate, String contractorFirstName, String contractorInn,
         String contractorLastName, String contractorPhone, String contractorSecondName, String errorCode,
         String errorMessage, String requestId, String status) {
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

   public String getMcUsername() {
      return mcUsername;
   }

   public void setMcUsername(String mcUsername) {
      this.mcUsername = mcUsername;
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
}
