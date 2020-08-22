package com.kmikhails.paymentaccount.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kmikhails.paymentaccount.model.PaymentAccount;
import com.kmikhails.paymentaccount.service.PaymentAccountService;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
   private static final PaymentAccount PAYMENT_ACCOUNT = new PaymentAccount("username", LocalDateTime.parse("2020-08-21T00:00:00"), "firstName",
         "1111", "lastName", "111-111-111", "secondName", "1111", "errorMessage", "1111", "status");
   
   @MockBean
   private PaymentAccountService paymentAccountServiceMock;
   
   @Autowired
   private MockMvc mockMvc;
   
   @Test
   void getPaymentAccountInfoShouldReturnPaymentAccount() throws Exception {
      when(paymentAccountServiceMock.getPaymentAccountInfo("username")).thenReturn(PAYMENT_ACCOUNT);
      
      mockMvc.perform(get("/account/info?mcUsername=username")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.mcUsername").value("username"))
            .andExpect(status().isOk());
   }
   
   @Test
   void addPaymentAccountInfoShouldCreateNewPaymentAccountInfo() throws Exception {
      when(paymentAccountServiceMock.save(PAYMENT_ACCOUNT)).thenReturn(PAYMENT_ACCOUNT);
      
      mockMvc.perform(post("/account/add")
            .content(createObjectMapper().writeValueAsString(PAYMENT_ACCOUNT))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
   }
   
   @Test
   void updatePaymentAccountInfoShouldUpdatePaymentAccountInfo() throws JsonProcessingException, Exception {
      when(paymentAccountServiceMock.getPaymentAccountInfo("username")).thenReturn(PAYMENT_ACCOUNT);
      when(paymentAccountServiceMock.save(PAYMENT_ACCOUNT)).thenReturn(PAYMENT_ACCOUNT);
      
      mockMvc.perform(put("/account/info?mcUsername=username")
            .content(createObjectMapper().writeValueAsString(PAYMENT_ACCOUNT))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
   }
   
   private static ObjectMapper createObjectMapper() {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
      objectMapper.registerModule(new JavaTimeModule());
      
      return objectMapper;
   }
}
