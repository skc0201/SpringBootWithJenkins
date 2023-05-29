package com.springboot.mongodb.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Department {
    @Field("department_name")
    private String departmentName;
    private String location;


}
