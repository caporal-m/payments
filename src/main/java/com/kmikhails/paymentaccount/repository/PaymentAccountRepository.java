package com.kmikhails.paymentaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmikhails.paymentaccount.model.PaymentAccount;

public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, String>{

}
