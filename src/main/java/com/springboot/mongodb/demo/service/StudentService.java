package com.springboot.mongodb.demo.service;

import com.springboot.mongodb.demo.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();

    public Student findById(String theId);

    public Student saveStudent(Student theStudent);

    public ResponseEntity<String> deleteById(String theId);

    public Student updateStudent(Student theStudent);

    public List<Student> getStudentsByName(String studentName);
    public List<Student> getStudentsByNameAndEmail(String studentName ,  String email);
    public List<Student> getStudentByPagination(int pageNo ,  int pageSize);

    public List<Student> getStudentBySorting();



}
