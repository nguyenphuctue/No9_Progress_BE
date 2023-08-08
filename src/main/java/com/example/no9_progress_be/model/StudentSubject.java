package com.example.no9_progress_be.model;

import jakarta.persistence.*;

@Entity
public class StudentSubject {

    @EmbeddedId
    StudentSubjectKey id;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @MapsId("sub_id")
    @JoinColumn(name = "sub_id")
    Subject subject;

    double mark;

}
