package com.example.data;

import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class ChineseIDCardNumberGeneratorTest {
    @Test
    public void generateRandomDate() {
        Date randomDate = ChineseIDCardNumberGenerator.randomDate();
        System.err.println(randomDate);
        assertNotNull(randomDate);
    }

    @Test
    public void testGenerate() {
        String idCard = ChineseIDCardNumberGenerator.getInstance().generate();
        System.err.println(idCard);
        System.out.println("Verify id result: " + ChineseIDCardUtil.isIDCard(idCard));
        assertNotNull(idCard);
        if (idCard.charAt(idCard.length()-2)%2 == 0){
            System.err.println("女");
        } else {
            System.err.println("男");
        }
    }

    @Test
    public void testGenerateIssueOrg() {
        String issueOrg = ChineseIDCardNumberGenerator.generateIssueOrg();
        System.err.println(issueOrg);
        assertNotNull(issueOrg);
    }

    @Test
    public void testGenerateValidPeriod() {
        String result = ChineseIDCardNumberGenerator.generateValidPeriod();
        System.err.println(result);
        assertNotNull(result);
    }
}
