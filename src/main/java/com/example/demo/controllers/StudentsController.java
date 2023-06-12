package com.example.demo.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Student;
import com.example.demo.models.StudentRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentsController {

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/students/view")
    public String getAllStudents(Model model){
        System.out.println("Getting all student");
        List<Student> students = studentRepo.findAll();
        //end of database call
        model.addAttribute("st", students);
        return "students/showAll";
    }

    @PostMapping("/students/add")
    public String addStudent(@RequestParam Map<String, String> newstudent, HttpServletResponse response){
        System.out.println("ADD student");
        String newName = newstudent.get("name");
        double newWeight = Double.parseDouble(newstudent.get("weight"));
        double newHeight = Double.parseDouble(newstudent.get("height"));
        double newGpa = Double.parseDouble(newstudent.get("gpa"));
        String newHairColor = newstudent.get("hairColor");
        studentRepo.save(new Student(newName,newWeight,newHeight,newGpa,newHairColor));
        response.setStatus(201);
        return "redirect:/students/view";
    }

    @GetMapping("/edit.html")
    public String getEditStudentPage(@RequestParam("uid") int uid, Model model) {
        Optional<Student> studentOptional = studentRepo.findById(uid);
        Student student = studentOptional.get();
        model.addAttribute("student", student);
        return "students/edit";
    }

    @PostMapping("/students/update")
    public String updateStudent(@RequestParam("uid") int uid, @RequestParam Map<String, String> updatedStudent, HttpServletResponse response) {
        Optional<Student> studentOptional = studentRepo.findById(uid);
        Student student = studentOptional.get();
        student.setName(updatedStudent.get("name"));
        student.setWeight(Double.parseDouble(updatedStudent.get("weight")));
        student.setHeight(Double.parseDouble(updatedStudent.get("height")));
        student.setGpa(Double.parseDouble(updatedStudent.get("gpa")));
        student.setHairColor(updatedStudent.get("hairColor"));
        studentRepo.save(student);
        response.setStatus(200);
        return "redirect:/students/view";
    }

    @PostMapping("/students/delete")
    public String deleteStudent(@RequestParam("uid") int uid, HttpServletResponse response) {
        Optional<Student> studentOptional = studentRepo.findById(uid);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            studentRepo.delete(student);
            response.setStatus(HttpServletResponse.SC_OK);
        }
        return "redirect:/students/view";
    }
}
