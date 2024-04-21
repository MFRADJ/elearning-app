package com.pfe.elearningapp.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professors")
public class professor extends user {
    @Column(nullable = false)
    private String department;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<course> courses = new HashSet<>();

    // Standard getters and setters...
}