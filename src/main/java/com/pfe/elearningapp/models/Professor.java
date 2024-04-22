package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends User {


    @Column(nullable = false)
    private String cvUrl;  // URL to the CV file stored externally

    @Column(nullable = false)
    private double hourlyRate;

    @Column()
    private String promotions;

    @Column(nullable = false)
    private String currentPosition;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfessionalExperience> professionalExperiences = new ArrayList<>();

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EducationDetails> educationalBackground = new ArrayList<>();

    public void addProfessionalExperience(ProfessionalExperience experience) {
        professionalExperiences.add(experience);
        experience.setProfessor(this);
    }

    public void addEducationDetail(EducationDetails education) {
        educationalBackground.add(education);
        education.setProfessor(this);
    }

    @Entity
    @Table(name = "professional_experiences")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProfessionalExperience {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "professor_id", nullable = false)
        private Professor professor;

        private String jobTitle;
        private String company;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String description;
    }

    @Entity
    @Table(name = "education_details")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EducationDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "professor_id", nullable = false)
        private Professor professor;

        private String degree;
        private String fieldOfStudy;
        private String schoolName;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
    }
}
