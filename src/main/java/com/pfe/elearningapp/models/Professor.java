package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professors")
@Getter
@Setter
@AllArgsConstructor
public class Professor extends User {
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfessionalExperience> professionalExperiences ;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EducationDetails> educationalBackground ;

    public Professor() {
        this.professionalExperiences = new ArrayList<>();
        this.educationalBackground = new ArrayList<>();
    }

    public void addProfessionalExperience(ProfessionalExperience experience) {
        professionalExperiences.add(experience);
        experience.setProfessor(this);
    }

    public void addEducationDetail(EducationDetails education) {
        educationalBackground.add(education);
        education.setProfessor(this);
    }

    // Classe interne non statique pour ProfessionalExperience
    @Entity
    @Table(name = "professional_experiences")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class ProfessionalExperience {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "professor_id", nullable = false)
        private Professor professor = Professor.this;

        private String jobTitle;
        private String company;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String description;


    }

    // Classe interne non statique pour EducationDetails
    @Entity
    @Table(name = "education_details")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class EducationDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "professor_id", nullable = false)
        private Professor professor = Professor.this;

        private String degree;
        private String fieldOfStudy;
        private String schoolName;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        // Getters and Setters
    }
}
