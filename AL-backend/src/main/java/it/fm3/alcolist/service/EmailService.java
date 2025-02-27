package it.fm3.alcolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements EmailServiceI {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    	private String emailAlcolist;
    
    public void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage(); 
        //message.setFrom("noreply@alcolist.com");
        message.setFrom(emailAlcolist);
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);

    }
}