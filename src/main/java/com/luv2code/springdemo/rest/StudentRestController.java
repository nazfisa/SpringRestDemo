package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if(studentId >= aStudent.size() || studentId < 0){
            throw new StudentNotFoundException("Student id is not found : "+ studentId);
        }
        return aStudent.get(studentId);
    }

}
