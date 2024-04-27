package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import lombok.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {


    @Column()
    @NotEmpty(message = "Major cannot be empty") // Validation pour s'assurer que le champ n'est pas vide
    private String major; // La spécialisation de l'étudiant, par exemple "Computer Science"

    @Column()
    private String studentStatus;  // Statut de l'étudiant, ex: "Full-time", "Part-time"

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments = new HashSet<>(); // Relations avec les inscriptions à des cours

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
