package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> aStudent;

    @PostConstruct
    public void loadData(){
        aStudent = new ArrayList<>();
        aStudent.add(new Student("Asif", "uddin"));
        aStudent.add(new Student("nazim","uddin"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return aStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return aStudent.get(studentId);
    }
}
