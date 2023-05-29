package com.springboot.mongodb.demo.controller;

import com.springboot.mongodb.demo.entity.Student;
import com.springboot.mongodb.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping()
    public Student addStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping()
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }
    @GetMapping("/{studentId}")
    public Student getAllStudents(@PathVariable String studentId){
        return studentService.findById(studentId);
    }

    @PutMapping()
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable String studentId){
        return studentService.deleteById(studentId);
    }

    @GetMapping("/name/{studentName}")
    public List<Student> getByStudentName(@PathVariable String studentName){
        return studentService.getStudentsByName(studentName);
    }
    @GetMapping("/byNameAndEmail")
    public List<Student> getByStudentNameAndEmail(@RequestParam String name , @RequestParam String email){
        return studentService.getStudentsByNameAndEmail(name, email);
    }
    @GetMapping("/pagination")
    public List<Student> getStudentsByPagination(@RequestParam int pageNo , @RequestParam int pageSize){
        return studentService.getStudentByPagination(pageNo, pageSize);
    }
    @GetMapping("/sorting")
    public List<Student> getStudentsBySorting(){
        return studentService.getStudentBySorting();
    }
}
