package com.solar.mail.utils;

/**
 * Created by hushaoge on 2017/9/15.
 * 邮件属性对象
 */
public class MailProperties {
    /**
     * 发件人邮箱
     */
    private String from;
    /**
     * 收件人邮箱
     */
    private String to;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件正文
     */
    private String content;
    /**
     * 指定发送邮件的主机
     */
    private String host = "smtp.sina.cn";

    /**
     * 邮箱账号,一般为@前面部分
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    private String type = "text/html;charset=gbk";

    public MailProperties(){}

    public MailProperties(String from, String to, String subject, String content){
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public MailProperties(String from, String to, String subject, String content, String account, String password){
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.account = account;
        this.password = password;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
