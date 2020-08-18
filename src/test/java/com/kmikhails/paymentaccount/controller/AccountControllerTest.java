package com.kmikhails.paymentaccount.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmikhails.paymentaccount.model.PaymentAccount;
import com.kmikhails.paymentaccount.service.PaymentAccountService;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
   private PaymentAccount paymentAccount = new PaymentAccount();

   @MockBean
   private PaymentAccountService paymentAccountServiceMock;
   
   @Autowired
   private MockMvc mockMvc;
   
   @Test
   void getPaymentAccountInfoShouldReturnPaymentAccount() throws Exception {
      paymentAccount.setMcUsername("username");
      
      when(paymentAccountServiceMock.getPaymentAccountInfo("username")).thenReturn(paymentAccount);
      
      mockMvc.perform(get("/account/info?mcUsername=username")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.mcUsername").value("username"))
            .andExpect(status().isOk());
   }
   
   @Test
   void addPaymentAccountInfoShouldCreateNewPaymentAccountInfo() throws Exception {
      when(paymentAccountServiceMock.save(paymentAccount)).thenReturn(paymentAccount);
      
      mockMvc.perform(post("/account/add")
            .content(new ObjectMapper().writeValueAsString(paymentAccount))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
   }
}
