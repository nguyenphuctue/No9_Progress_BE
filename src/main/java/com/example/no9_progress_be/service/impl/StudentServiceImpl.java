package com.example.no9_progress_be.service.impl;

import com.example.no9_progress_be.model.Student;
import com.example.no9_progress_be.repository.StudentRepository;
import com.example.no9_progress_be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(long id, Student newStudent) {
        Optional<Student> student = studentRepository.findById(id);
        student.ifPresent(s -> {
            s.setName(newStudent.getName());
            s.setGender(newStudent.getGender());
            s.setBirthday(newStudent.getBirthday());
            s.setClassA(newStudent.getClassA());
            s.setMarks(newStudent.getMarks());
            studentRepository.save(s);
        });
        return newStudent;
    }

    @Override
    public boolean deleteStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
