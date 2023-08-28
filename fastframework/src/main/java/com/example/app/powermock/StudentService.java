package com.example.app.powermock;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int getTotal() {
        return studentDao.getTotal();
    }

    public void createStudent(Student student) {
        studentDao.createStudent(student);
    }
}
