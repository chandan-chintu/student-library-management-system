package com.example.student_library_management_system.controller;


import com.example.student_library_management_system.requestdto.StudentRequestDto;
import com.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.saveStudents(studentRequestDto);
        return response;
    }

    @DeleteMapping("/delete/{studentid}")
    public String deleteStudentById(@PathVariable("studentid") int studentId){
        String response = studentService.deleteStudentById(studentId);
        return response;
    }
}
