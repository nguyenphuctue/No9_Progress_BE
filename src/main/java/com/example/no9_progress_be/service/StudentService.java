package com.example.no9_progress_be.service;

import com.example.no9_progress_be.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(long id);
    Student getStudentByName(String name);
    Student addStudent(Student student);
    Student updateStudent(long id, Student student);
    boolean deleteStudentById(long id);
}
