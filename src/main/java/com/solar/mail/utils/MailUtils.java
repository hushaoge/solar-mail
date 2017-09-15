package com.solar.mail.utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * Created by hushaoge on 2017/9/15.
 * 邮件发送
 */
public class MailUtils {

    public static boolean sendMessage(MailProperties mailProperties){
        if(mailProperties == null){
            return false;
        }
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", mailProperties.getHost());
        properties.setProperty("mail.smtp.auth", "true");

        Session session = getSession(properties, mailProperties.getAccount(), mailProperties.getPassword());
        MimeMessage mimeMessage = getMimeMessage(session, mailProperties);
        // 发送消息
        return sendMessage(mimeMessage);
    }

    public static boolean sendEnclosure(MailProperties mailProperties,  File file){
        if(mailProperties == null){
            return false;
        }
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", mailProperties.getHost());
        properties.setProperty("mail.smtp.auth", "true");

        Session session = getSession(properties, mailProperties.getAccount(), mailProperties.getPassword());
        MimeMessage mimeMessage = getMimeMessage(session, mailProperties);
        try {
            // 创建消息部分
            BodyPart messageBodyPart = new MimeBodyPart();

            // 消息
            messageBodyPart.setText("This is message body");

            // 创建多重消息
            Multipart multipart = new MimeMultipart();

            // 设置文本消息部分
            multipart.addBodyPart(messageBodyPart);

            // 附件部分
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("附件");
            multipart.addBodyPart(messageBodyPart);

            // 发送完整消息
            mimeMessage.setContent(multipart);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // 发送消息
        return sendMessage(mimeMessage);
    }

    public static boolean sendMessage(MimeMessage mimeMessage){
        if(mimeMessage == null){
            return false;
        }
        try {
            Transport.send(mimeMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Session getSession(Properties properties, final String userName, final String password){
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、密码
                return new PasswordAuthentication(userName, password);
            }
        });
        return session;
    }

    public static MimeMessage getMimeMessage(Session session, MailProperties mailProperties){
        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage mimeMessage = new MimeMessage(session);
            // Set From: 头部头字段
            mimeMessage.setFrom(new InternetAddress(mailProperties.getFrom()));
            // Set To: 头部头字段
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailProperties.getTo()));
            // Set Subject: 头部头字段
            mimeMessage.setSubject(mailProperties.getSubject());
            // 设置消息体
            mimeMessage.setContent(mailProperties.getContent(), mailProperties.getType());
            return mimeMessage;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
