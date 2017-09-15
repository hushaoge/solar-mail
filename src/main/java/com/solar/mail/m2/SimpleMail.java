package com.solar.mail.m2;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by hushaoge on 2017/9/15.
 */
public class SimpleMail {
    public static void main(String[] args) {
        // 收件人电子邮箱
        String to = "224451673@qq.com";
        // 发件人电子邮箱
        String from = "hushaoge@sina.cn";
        // 指定发送邮件的主机为 localhost
        String host = "smtp.sina.cn";
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");

                // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、密码
                return new PasswordAuthentication("hushaoge", "");
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage mimeMessage = new MimeMessage(session);
            // Set From: 头部头字段
            mimeMessage.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: 头部头字段
            mimeMessage.setSubject("");
            // 设置消息体
            mimeMessage.setText("This is actual message");
            // 发送消息
            Transport.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
