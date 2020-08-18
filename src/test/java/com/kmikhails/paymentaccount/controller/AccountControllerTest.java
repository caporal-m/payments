package com.kmikhails.paymentaccount.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.kmikhails.paymentaccount.model.PaymentAccount;
import com.kmikhails.paymentaccount.service.PaymentAccountService;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
   private static final PaymentAccount PAYMENT_ACCOUNT = new PaymentAccount();

   @MockBean
   private PaymentAccountService paymentAccountServiceMock;
   
   @Autowired
   private MockMvc mockMvc;
   
   @Test
   void getPaymentAccountInfoShouldReturnPaymentAccount() throws Exception {
      PAYMENT_ACCOUNT.setMcUsername("username");
      
      when(paymentAccountServiceMock.getPaymentAccountInfo("username")).thenReturn(PAYMENT_ACCOUNT);
      
      mockMvc.perform(get("/account/info?mcUsername=username")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.mcUsername").value("username"))
            .andExpect(status().isOk());
   }
}
