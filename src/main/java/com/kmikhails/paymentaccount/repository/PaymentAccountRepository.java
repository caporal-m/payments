package com.kmikhails.paymentaccount.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kmikhails.paymentaccount.model.PaymentAccount;

public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, String>{

   List<PaymentAccount> findAllByStatus(String status, Sort sort);
}
