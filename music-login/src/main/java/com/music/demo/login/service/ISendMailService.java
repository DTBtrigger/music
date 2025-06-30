package com.music.demo.login.service;

public interface ISendMailService {

    void sendMail(String to, String subject, String content);
}
