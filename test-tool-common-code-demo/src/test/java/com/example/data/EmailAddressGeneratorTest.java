package com.example.data;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmailAddressGeneratorTest {
    @Test
    public void testGenerate() {
        for(int i=0; i<10; i++) {
            String generatedEmail = EmailAddressGenerator.getInstance().generate();
            System.err.println(generatedEmail);
            assertNotNull(generatedEmail);
        }
    }
}
