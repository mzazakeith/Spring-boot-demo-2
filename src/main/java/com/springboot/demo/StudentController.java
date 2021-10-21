package com.springboot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    this method returns a java bean object
    @GetMapping(path="/student")
    public Student getStudent(){
        return new Student("Keith", "Mzaza");
    }

    //this returns a list
    @GetMapping(path="/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Keith", "Mzaza"));
        students.add(new Student("Elizabeth", "Nzisa"));
        students.add(new Student("Maxine", "Wabosha"));
        students.add(new Student("Emmanuel", "Mwazighe"));
        return students;
    }


}
