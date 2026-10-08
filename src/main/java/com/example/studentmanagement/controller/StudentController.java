package com.example.studentmanagement.controller;

import com.example.studentmanagement.Student;
import com.example.studentmanagement.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", repository.findAll());
        return "index";
    }

    @PostMapping("/students")
    public String addStudent(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String course) {

        Student student = new Student(name, email, course);
        repository.save(student);

        return "redirect:/";
    }
}
