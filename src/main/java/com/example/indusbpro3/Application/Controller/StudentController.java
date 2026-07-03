package com.example.indusbpro3.Application.Controller;

import com.example.indusbpro3.Domain.entity.Student;
import com.example.indusbpro3.External.repository.StudentRepository;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/Detailes")
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student Added Successfully!";
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
            return "Student Updated Successfully!";
        }
        return "Student Not Found!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        return "Student Deleted Successfully!";
    }


}



