package com.example.data;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChineseAddressGeneratorTest {

    @Test
    public void testGenerate() {
        String generatedAddress = ChineseAddressGenerator.getInstance()
                .generate();
        System.err.println(generatedAddress);
        assertNotNull(generatedAddress);
    }
}
