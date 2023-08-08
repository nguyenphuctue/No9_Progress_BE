package com.example.no9_progress_be.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentSubjectKey implements Serializable {
    @Column(name = "student_id")
    int student_id;

    @Column(name = "sub_id")
    int sub_id;
}
