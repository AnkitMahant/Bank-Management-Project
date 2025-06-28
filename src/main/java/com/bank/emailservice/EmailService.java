package com.bank.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendAccountCreationEmail(String toEmail, String customerName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ankituttammahant@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Bank Account Created Successfully");
        message.setText("Dear " + customerName + ",\n\nYour bank account has been created successfully.\n\nThank you for choosing our service!");

        mailSender.send(message);
    }
}
