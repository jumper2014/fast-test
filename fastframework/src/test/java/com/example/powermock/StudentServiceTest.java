package com.example.powermock;

import com.example.app.powermock.Student;
import com.example.app.powermock.StudentDao;
import com.example.app.powermock.StudentService;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;

public class StudentServiceTest {


    @Test
    public void testAddStudent() {
//        StudentDao studentDao = new StudentDao();
        StudentDao studentDao = PowerMockito.mock(StudentDao.class);
        PowerMockito.when(studentDao.getTotal()).thenReturn(666);
        StudentService studentService = new StudentService(studentDao);
        int total = studentService.getTotal();
        Assert.assertEquals(total, 666);
    }

    @Test
    public void testCreateStudentWithMock() {
        StudentDao studentDao = PowerMockito.mock(StudentDao.class);
        Student student=new Student();
        PowerMockito.doNothing().when(studentDao).createStudent(student);
        StudentService studentService = new StudentService(studentDao);
        studentService.createStudent(student);
        Mockito.verify(studentDao).createStudent(student);
    }
}
