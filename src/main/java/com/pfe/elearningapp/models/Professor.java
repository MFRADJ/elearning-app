package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Professor extends User {

    @Column(nullable = false)
    private String department;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Course> course = new HashSet<>();


}