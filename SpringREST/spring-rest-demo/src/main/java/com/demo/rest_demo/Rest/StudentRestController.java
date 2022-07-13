package com.demo.rest_demo.Rest;

import com.demo.rest_demo.Entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadStudent()
    {
        students = new ArrayList<>();
        students.add(new Student("Poornima","patel"));
        students.add(new Student("Mary","Smith"));
        students.add(new Student("John","Kelly"));

    }

    @GetMapping("/student")
    public List<Student> studentList()
    {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId )
    {
        return students.get(studentId);
    }
}
