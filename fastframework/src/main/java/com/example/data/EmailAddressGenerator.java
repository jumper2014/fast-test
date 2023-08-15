package com.example.data;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

/*
        合法的电子邮件地址通常需要满足以下条件：
        包含一个@符号，将地址分为用户名和域名两部分。
        用户名和域名都不能包含特殊字符，如空格、逗号等。
        域名必须包含一个"."符号，并且最后一个"."后面必须有两到六个字母。
     */
public class EmailAddressGenerator extends GenericGenerator {
    private static final String[] DOMAINS = {
            "cn", "us", "uk", "de", "jp", "fr", "au", "ru", "es", "br",
            "com", "net", "org", "edu", "gov", "mil",
            "info", "biz", "mobi", "tv", "io", "me", "co", "xyz",
            "ca", "in", "it", "pl", "nl", "se", "ch", "sg", "kr", "za",
            "nz", "at", "be", "dk", "fi", "no", "pt", "tr", "hk", "tw",
            "us", "uk", "de", "jp", "fr", "au", "ru", "es", "br", "ca",
            "se", "ch", "sg", "kr", "za", "nz", "at", "be", "dk", "fi",
            "no", "pt", "tr", "hk", "tw", "my", "vn", "id", "mx", "ar",
            "cl", "co", "pe", "ve", "ec", "eg", "ae", "qa", "sa", "kw"
    };
    private static GenericGenerator instance = new EmailAddressGenerator();

    private EmailAddressGenerator() {
    }

    public static GenericGenerator getInstance() {
        return instance;
    }


    @Override
    public String generate() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        result.append(RandomStringUtils.randomAlphanumeric(10));
        result.append("@");

        result.append(RandomStringUtils.randomAlphanumeric(5));
        result.append(".");
        // 随机选择一个域名
        int domainIndex = random.nextInt(DOMAINS.length);
        result.append(DOMAINS[domainIndex]);

        return result.toString().toLowerCase();
    }
}
