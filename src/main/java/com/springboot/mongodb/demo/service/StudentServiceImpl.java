package com.springboot.mongodb.demo.service;

import com.springboot.mongodb.demo.entity.Student;
import com.springboot.mongodb.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String theId) {
        Student theStudent = studentRepository.findById(theId).get();

        System.out.println(theStudent + "the student-----");

        if (theStudent == null) {
            throw new RuntimeException("Student id not found - " + theId);
        }

        return theStudent;
    }

    @Override
    public Student saveStudent(Student theStudent) {
     return studentRepository.save(theStudent);
    }

    @Override
    public ResponseEntity<String> deleteById(String theId) {
         studentRepository.deleteById(theId);
    return ResponseEntity.ok("Student has been deleted successfully!!!!");
    }

    @Override
    public Student updateStudent(Student theStudent) {
        Student student = studentRepository.findById(theStudent.getId()).get();
        System.out.println(theStudent + "the student-----");
        if (theStudent == null) {
            throw new RuntimeException("Student id not found - " + theStudent.getId());
        }
        return studentRepository.save(theStudent);
    }

    @Override
    public List<Student> getStudentsByName(String studentName) {
        return studentRepository.findByName(studentName);
    }

    @Override
    public List<Student> getStudentsByNameAndEmail(String studentName, String email) {
        return studentRepository.findByNameAndEmail(studentName , email);    }

    @Override
    public List<Student> getStudentByPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> getStudentBySorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return studentRepository.findAll(sort);
    }
}
