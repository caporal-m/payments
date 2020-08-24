package com.kmikhails.paymentaccount.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.kmikhails.paymentaccount.util.LocalDateTimeAdapter; 

@Entity
@Table(name = "payment_account")
@XmlRootElement(name = "paymentAccount")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentAccount {

   @Id
   @NotNull
   private String mcUsername;
   
   @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
   private LocalDateTime changeDate;

   @NotNull(message = "Firstname is a required field")
   @Pattern(regexp = "^[а-яёА-ЯЁ]+")
   private String contractorFirstName;

   @NotNull
   @Size(min = 12, max = 12)
   @Pattern(regexp = "\\d+", message = "Only digits required")
   private String contractorInn;

   @NotNull(message = "Lastname is a required field")
   @Pattern(regexp = "^[а-яёА-ЯЁ]+")
   private String contractorLastName;

   @NotNull
   @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "Incorrect phone number")
   private String contractorPhone;

   @NotNull(message = "Secondname is a required field")
   @Pattern(regexp = "^[а-яёА-ЯЁ]+")
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

   @Override
   public String toString() {
      return "PaymentAccount [mcUsername=" + mcUsername + ", changeDate=" + changeDate + ", contractorFirstName="
            + contractorFirstName + ", contractorInn=" + contractorInn + ", contractorLastName=" + contractorLastName
            + ", contractorPhone=" + contractorPhone + ", contractorSecondName=" + contractorSecondName + ", errorCode="
            + errorCode + ", errorMessage=" + errorMessage + ", requestId=" + requestId + ", status=" + status + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(changeDate, contractorFirstName, contractorInn, contractorLastName, contractorPhone,
            contractorSecondName, errorCode, errorMessage, mcUsername, requestId, status);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      PaymentAccount paymentAccount = (PaymentAccount) obj;
      return Objects.equals(changeDate, paymentAccount.changeDate)
            && Objects.equals(contractorFirstName, paymentAccount.contractorFirstName)
            && Objects.equals(contractorInn, paymentAccount.contractorInn)
            && Objects.equals(contractorLastName, paymentAccount.contractorLastName)
            && Objects.equals(contractorPhone, paymentAccount.contractorPhone)
            && Objects.equals(contractorSecondName, paymentAccount.contractorSecondName)
            && Objects.equals(errorCode, paymentAccount.errorCode) 
            && Objects.equals(errorMessage, paymentAccount.errorMessage)
            && Objects.equals(mcUsername, paymentAccount.mcUsername) 
            && Objects.equals(requestId, paymentAccount.requestId)
            && Objects.equals(status, paymentAccount.status);
   }
}
