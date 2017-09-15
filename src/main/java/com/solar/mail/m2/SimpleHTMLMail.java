package com.solar.mail.m2;

import com.solar.mail.utils.MailProperties;
import com.solar.mail.utils.MailUtils;

/**
 * Created by hushaoge on 2017/9/15.
 */
public class SimpleHTMLMail {
    public static void main(String[] args) {
        MailProperties mailProperties = new MailProperties(
                    "hushaoge@sina.cn",
                    "57324567@qq.com",
                    "test",
                    "<table><tr><td>可以插入HTML哦</td></tr></table>",
                    "hushaoge",
                    "*****"
                );
        MailUtils.sendMessage(mailProperties);
    }
}
