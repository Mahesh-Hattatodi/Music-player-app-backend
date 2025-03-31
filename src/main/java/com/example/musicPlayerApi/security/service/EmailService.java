package com.example.musicPlayerApi.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;

    // If @Slf4j is not used then you need to create the instance of the Logger class like this
    // private static final Logger logger = (Logger) LoggerFactory.getLogger(EmailService.class);

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        try {
            log.debug("Inside sending process");
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom("hmahesh554@gmail.com");
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            log.debug("Before sending email content is " + mail);
            javaMailSender.send(mail);
            log.debug("Email sent successfully");
        } catch (Exception e) {
            log.error("Exception while sending email ", e);
        }
    }
}
