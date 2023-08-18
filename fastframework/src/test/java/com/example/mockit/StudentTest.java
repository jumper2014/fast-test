package com.example.mockit;

import com.example.App;
import com.example.app.mockit.Lab;
import com.example.app.mockit.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = App.class)
public class StudentTest {
    @InjectMocks
    Student student;
    @Mock
    Lab lab;

    @Test
    public void testMockReturn() {
        when(lab.getExpScore(anyString())).thenReturn(90);
        Assert.assertTrue(student.passMathExp());
    }

    @Test(expected = Exception.class)
    public void testMockException() {
        when(lab.getExpScore(anyString())).thenThrow(new Exception("hello world"));
        student.passPhyExp();
    }
}
