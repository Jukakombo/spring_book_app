package com.reactDemo.service;

import com.reactDemo.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();
    Student addStudent(Student student);
    Student updateStudent(Student student, Long id);
    Student getSingleStudentById(Long id);
    void deleteStudent(Long id);
}
