package com.springboot.mongodb.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    private String name;

    private String email;

    private  Department department;

    private List<Subject> subjects;

}
