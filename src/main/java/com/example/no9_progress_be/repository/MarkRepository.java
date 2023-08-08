package com.example.no9_progress_be.repository;

import com.example.no9_progress_be.model.StudentSubject;
import com.example.no9_progress_be.model.StudentSubjectKey;
import com.example.no9_progress_be.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<StudentSubject, StudentSubjectKey> {
    List<StudentSubject> findByMark(double mark);
}
