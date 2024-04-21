package com.pfe.elearningapp.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends User {
    @Column(nullable = true)
    private String studyLevel;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private Set<Course> enrolledCours = new HashSet<>();


}