package com.example.powermock;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import static org.mockito.Mockito.*;

import com.example.app.powermock.HelperUtils;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;

@PrepareForTest(HelperUtils.class)
public class TestNGPowerMockitoStaticTest extends PowerMockTestCase{

    @Test
    public void test_static_mock_methods() {
        PowerMockito.mockStatic(HelperUtils.class);
        when(HelperUtils.print("Hello")).thenReturn(true);
        when(HelperUtils.print("Wrong Message")).thenReturn(false);

        assertTrue(HelperUtils.print("Hello"));
        assertFalse(HelperUtils.print("Wrong Message"));

        PowerMockito.verifyStatic(HelperUtils.class);
        HelperUtils.print("Hello");
        PowerMockito.verifyStatic(HelperUtils.class, times(2));
        HelperUtils.print(anyString());
    }
}