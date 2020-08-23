package com.kmikhails.paymentaccount.scheduler;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kmikhails.paymentaccount.model.PaymentAccount;
import com.kmikhails.paymentaccount.model.PaymentAccounts;
import com.kmikhails.paymentaccount.service.EmailService;
import com.kmikhails.paymentaccount.service.PaymentAccountService;

@Component
public class Scheduler {
   @Value("${mail.destination}")
   private String email;
   
   @Autowired
   private PaymentAccountService paymentAccountService;
   
   @Autowired
   private EmailService emailService;

   @Scheduled(cron="0 1 1 * * *", zone="Asia/Yekaterinburg")
   public void sendEmail() throws JAXBException, MessagingException {
      emailService.sendAttachmentEmail(email, "subject", "text", parseToXml());
   }
   
   private List<PaymentAccount> getPaymentAccounts() {
      return paymentAccountService.getListByStatus("error", Sort.by(Sort.Direction.ASC, "changeDate"));
   }
   
   private File parseToXml() throws JAXBException {
      JAXBContext jaxbContext = JAXBContext.newInstance(PaymentAccounts.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      
      File file = new File("paymentAccount.xml");
      PaymentAccounts paymentAccounts = new PaymentAccounts();
      paymentAccounts.setPaymentAccounts(getPaymentAccounts());
      
      jaxbMarshaller.marshal(paymentAccounts, file);
      
      return file;
   }
}
