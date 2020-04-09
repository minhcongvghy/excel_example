package com.vsii.excelexample;

import com.vsii.excelexample.email.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    @Autowired
    public JavaMailSender emailSender;

    public String sendSimpleEmail() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Notification");
        message.setText("Insert Database successfully");

        // Send Message!
        this.emailSender.send(message);

        return "Email Sent!";
    }
}
