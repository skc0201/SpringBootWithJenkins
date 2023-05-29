package com.springboot.mongodb.demo.repository;

import com.springboot.mongodb.demo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    List<Student> findByName(String name);
    List<Student> findByNameAndEmail(String name, String email);


}
