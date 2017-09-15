package com.solar.mail.m2;

import com.solar.mail.utils.MailProperties;
import com.solar.mail.utils.MailUtils;

import java.io.File;

/**
 * Created by hushaoge on 2017/9/15.
 * 带附件邮件
 */
public class SimpleEnclosureMail {
    public static void main(String[] args) {
        MailProperties mailProperties = new MailProperties(
                "hushaoge@sina.cn",
                "243567890@qq.com",
                "test",
                "<table><tr><td>可以插入HTML哦</td></tr></table>",
                "hushaoge",
                "****"
        );
       MailUtils.sendEnclosure(mailProperties, new File("F://caseinfo.ser"));
    }
}
