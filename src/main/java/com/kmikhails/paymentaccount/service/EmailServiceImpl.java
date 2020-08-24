package com.kmikhails.paymentaccount.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
   @Value("${spring.mail.username}")
   private String username;

   @Autowired
   private JavaMailSender javaMailSender;

   @Override
   public void sendAttachmentEmail(String to, String subject, String text, File attachfile) throws MessagingException {
      javaMailSender.send(new MimeMessagePreparator() {

         public void prepare(MimeMessage mimeMessage) throws Exception {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setSubject(subject);
            helper.setText(text, true);
            helper.setTo(to);
            helper.setFrom(username);

            if (attachfile != null) {
               helper.addAttachment(attachfile.getName(), new InputStreamSource() {
                  public InputStream getInputStream() throws IOException {
                     return new FileInputStream(attachfile);
                  }
               });
            }
         }
      });
   }
}
