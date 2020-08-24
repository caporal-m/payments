package com.kmikhails.paymentaccount.util;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
   
   public LocalDateTime unmarshal(String date) throws Exception {
       return LocalDateTime.parse(date);
   }

   public String marshal(LocalDateTime date) throws Exception {
       return date.toString();
   }
}
