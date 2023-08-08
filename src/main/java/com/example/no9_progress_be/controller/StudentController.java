package com.example.no9_progress_be.controller;

import com.example.no9_progress_be.model.Student;
import com.example.no9_progress_be.model.StudentSubject;
import com.example.no9_progress_be.model.StudentSubjectKey;
import com.example.no9_progress_be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Student>> getAllStudents(){
        return  ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Optional<Student> student = studentService.getStudentById(id);
        if(student.isPresent()){
            return ResponseEntity.ok(student.get());
        }

        return ResponseEntity.ok(null);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return  new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student){
        return  new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        boolean check = studentService.deleteStudentById(id);
        if (check) return new ResponseEntity<>("Deleted success", HttpStatus.OK);
        return new ResponseEntity<>("Deleted fail", HttpStatus.OK);
    }
}
