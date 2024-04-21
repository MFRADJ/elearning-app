package com.pfe.elearningapp.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class student extends user {
    @Column(nullable = true)
    private String studyLevel;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private Set<course> enrolledCourses = new HashSet<>();


}