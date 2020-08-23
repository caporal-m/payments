package com.kmikhails.paymentaccount.service;

import java.io.File;

import javax.mail.MessagingException;

public interface EmailService {

   void sendAttachmentEmail(String to, String subject, String text, File attachfile) throws MessagingException;
}
