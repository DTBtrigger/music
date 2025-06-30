package com.music.demo.login.service.impl;

import com.music.demo.common.exception.message.MessageException;
import com.music.demo.login.service.ISendMailService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ISendServiceImpl implements ISendMailService{

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;


    @Override
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        mailSender.send(message);
    }
}