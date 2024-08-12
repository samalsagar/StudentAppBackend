package com.sagar.studentSystem.controller;

import com.sagar.studentSystem.model.Student;
import com.sagar.studentSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String saveStudent(@RequestBody Student student) {
//        studentService.saveStudent(student);
        String msg = "";
        if(!student.getName().isEmpty() && !student.getAddress().isEmpty()) {
            studentService.saveStudent(student);
            msg += student.getName() + " Added to the team";
        } else {
            msg += "Please enter valid details for a student";
        }

        return msg;

    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }
}
