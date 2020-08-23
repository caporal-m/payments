package com.kmikhails.paymentaccount.util;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kmikhails.paymentaccount.model.PaymentAccount;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvParser {
   
   private CsvParser() {
      
   }

   public static List<PaymentAccount> parse(String filename) {
      List<List<String>> records = new ArrayList<>();
      
      try (CSVReader csvReader = new CSVReader(new FileReader(filename));) {
          String[] values;
          while ((values = csvReader.readNext()) != null) {
              records.add(Arrays.asList(values));
          }
      } catch (CsvValidationException | IOException e) {
         e.printStackTrace();
      }
      
      List<PaymentAccount> paymentAccounts = new ArrayList<>();
      for(int i = 1; i < records.size(); i++) {
         paymentAccounts.add(createPaymentAccount(records.get(i)));
      }
      return paymentAccounts;
   }
   
   private static PaymentAccount createPaymentAccount(List<String> record) {
      PaymentAccount paymentAccount = new PaymentAccount();
      paymentAccount.setMcUsername(record.get(0));
      paymentAccount.setChangeDate(LocalDateTime.parse(record.get(1)));
      paymentAccount.setContractorFirstName(record.get(2));
      paymentAccount.setContractorInn(record.get(3));
      paymentAccount.setContractorLastName(record.get(4));
      paymentAccount.setContractorPhone(record.get(5));
      paymentAccount.setContractorSecondName(record.get(6));
      paymentAccount.setErrorCode(record.get(7));
      paymentAccount.setErrorMessage(record.get(8));
      paymentAccount.setRequestId(record.get(9));
      paymentAccount.setStatus(record.get(10));
      
      return paymentAccount;
   }
}
