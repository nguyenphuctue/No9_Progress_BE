package com.example.no9_progress_be.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String birthday;
    private String gender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="class_id", referencedColumnName = "id")
    private ClassA classA;

    @OneToMany(mappedBy = "student")
    private Set<StudentSubject> marks;
}
