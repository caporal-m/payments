package com.kmikhails.paymentaccount.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
   private static final PaymentAccount PAYMENT_ACCOUNT = new PaymentAccount("username", LocalDateTime.parse("2020-08-21T00:00:00"), "Имя",
         "123456789012", "Фамилия", "89261234567", "Отчество", "1111", "errorMessage", "1111", "status");
   
   @MockBean
   private PaymentAccountService paymentAccountServiceMock;
   
   @Autowired
   private MockMvc mockMvc;
   
   @Test
   void getPaymentAccountInfoShouldReturnPaymentAccount() throws Exception {
      when(paymentAccountServiceMock.getPaymentAccountInfo("username")).thenReturn(PAYMENT_ACCOUNT);
      
      mockMvc.perform(get("/account/info?mcUsername=username")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.mcUsername", is("username")))
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
   
   @Test
   void addPaymentAccountInfoShouldThrowMethodArgumentNotValidExceptionWhenContractorFirstNameDoesNotMatchPattern() throws Exception {
      PaymentAccount paymentAccount = new PaymentAccount("username", LocalDateTime.parse("2020-08-21T00:00:00"), "Name",
            "123456789012", "Фамилия", "89261234567", "Отчество", "1111", "errorMessage", "1111", "status");
      
      when(paymentAccountServiceMock.save(paymentAccount)).thenReturn(paymentAccount);
      
      mockMvc.perform(post("/account/add")
            .content(createObjectMapper().writeValueAsString(paymentAccount))
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status", is(400)))
            .andExpect(jsonPath("$.errors", hasItem("must match \"^[а-яёА-ЯЁ]+\"")));
   }
   
   @Test
   void addPaymentAccountInfoShouldThrowMethodArgumentNotValidExceptionWhenContractorLastNameDoesNotMatchPattern() throws Exception {
      PaymentAccount paymentAccount = new PaymentAccount("username", LocalDateTime.parse("2020-08-21T00:00:00"), "Имя",
            "123456789012", "Family", "89261234567", "Отчество", "1111", "errorMessage", "1111", "status");
      
      when(paymentAccountServiceMock.save(paymentAccount)).thenReturn(paymentAccount);
      
      mockMvc.perform(post("/account/add")
            .content(createObjectMapper().writeValueAsString(paymentAccount))
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status", is(400)))
            .andExpect(jsonPath("$.errors", hasItem("must match \"^[а-яёА-ЯЁ]+\"")));
   }
   
   @Test
   void addPaymentAccountInfoShouldThrowMethodArgumentNotValidExceptionWhenContractorSecondNameDoesNotMatchPattern() throws Exception {
      PaymentAccount paymentAccount = new PaymentAccount("username", LocalDateTime.parse("2020-08-21T00:00:00"), "Имя",
            "123456789012", "Фамилия", "89261234567", "secondname", "1111", "errorMessage", "1111", "status");
      
      when(paymentAccountServiceMock.save(paymentAccount)).thenReturn(paymentAccount);
      
      mockMvc.perform(post("/account/add")
            .content(createObjectMapper().writeValueAsString(paymentAccount))
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status", is(400)))
            .andExpect(jsonPath("$.errors", hasItem("must match \"^[а-яёА-ЯЁ]+\"")));
   }
   
   @Test
   void addPaymentAccountInfoShouldThrowMethodArgumentNotValidExceptionWhenContractorInnDoesNotMatchPattern() throws Exception {
      PaymentAccount paymentAccount = new PaymentAccount("username", LocalDateTime.parse("2020-08-21T00:00:00"), "Имя",
            "inn", "Фамилия", "89261234567", "Отчество", "1111", "errorMessage", "1111", "status");
      
      when(paymentAccountServiceMock.save(paymentAccount)).thenReturn(paymentAccount);
      
      mockMvc.perform(post("/account/add")
            .content(createObjectMapper().writeValueAsString(paymentAccount))
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.errors", hasItem("Only digits required")))
            .andExpect(jsonPath("$.errors", hasItem("size must be between 12 and 12")));
   }
   
   @Test
   void addPaymentAccountInfoShouldThrowMethodArgumentNotValidExceptionWhenContractorPhoneDoesNotMatchPattern() throws Exception {
      PaymentAccount paymentAccount = new PaymentAccount("username", LocalDateTime.parse("2020-08-21T00:00:00"), "Имя",
            "123456789012", "Фамилия", "number123", "Отчество", "1111", "errorMessage", "1111", "status");
      
      when(paymentAccountServiceMock.save(paymentAccount)).thenReturn(paymentAccount);
      
      mockMvc.perform(post("/account/add")
            .content(createObjectMapper().writeValueAsString(paymentAccount))
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value(400))
            .andExpect(jsonPath("$.errors", hasItem("Incorrect phone number")));
   }
   
   private static ObjectMapper createObjectMapper() {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
      objectMapper.registerModule(new JavaTimeModule());
      
      return objectMapper;
   }
}
