package com.solar.mail.m1;

public class SendMail {
    public static void main(String[] args) {
        String smtp = "smtp.sina.cn";// smtp服务器
        String from = "hushaoge@sina.cn";// 邮件显示名称
        String to = "223134432@qq.com";// 收件人的邮件地址，必须是真实地址
        String copyto = "";// 抄送人邮件地址
        String subject = "测试邮件";// 邮件标题
        String username = "hushaoge";// 发件人真实的账户名
        String password = "***";// 发件人密码

        StringBuffer content = new StringBuffer();
        content.append("胡稍葛，你好:");// 邮件内容
        content.append("<br>");
        content.append("&nbsp;&nbsp;&nbsp;&nbsp;这是测试代码！");
        StringBuffer postfix = new StringBuffer();
        postfix.append("<br>");
        postfix.append("<br>");
        postfix.append("<hr align='left' width='50%' />");
        postfix.append("胡稍葛");
        postfix.append("<br>");
        postfix.append("有限公司");
        postfix.append("<br>");
        postfix.append("杭州市滨江区");
        postfix.append("<br>");
        postfix.append("电话：15088751017");
        postfix.append("<br>");
        postfix.append("邮箱：XXXX");
        postfix.append("<br>");
        content.append(postfix.toString());
        Mail.sendAndCc(smtp, from, to, copyto, subject, content.toString(), username, password);
    }
}
