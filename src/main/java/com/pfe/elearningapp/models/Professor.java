package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

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
    @NotEmpty(message = "CV URL cannot be empty")
    @URL(message = "Must be a valid URL")
    private String cvUrl;  // URL to the CV file stored externally

    @Column(nullable = false)
    @DecimalMin(value = "0.0", inclusive = false, message = "Hourly rate must be greater than zero")
    private double hourlyRate;

    @Column
    private String promotions;

    @Column(nullable = false)
    @NotEmpty(message = "Current position cannot be empty")
    private String currentPosition;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfessionalExperience> professionalExperiences = new ArrayList<>();

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EducationDetails> educationalBackground = new ArrayList<>();

    public void addProfessionalExperience(ProfessionalExperience experience) {
        if (experience != null) {
            professionalExperiences.add(experience);
            experience.setProfessor(this);
        }
    }

    public void addEducationDetail(EducationDetails education) {
        if (education != null) {
            educationalBackground.add(education);
            education.setProfessor(this);
        }
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

        @NotEmpty(message = "Job title cannot be empty")
        private String jobTitle;

        @NotEmpty(message = "Company name cannot be empty")
        private String company;

        @NotNull(message = "Start date cannot be null")
        private LocalDateTime startDate;

        @NotNull(message = "End date cannot be null")
        private LocalDateTime endDate;

        @Size(max = 500, message = "Description cannot exceed 500 characters")
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

        @NotEmpty(message = "Degree cannot be empty")
        private String degree;

        @NotEmpty(message = "Field of study cannot be empty")
        private String fieldOfStudy;

        @NotEmpty(message = "School name cannot be empty")
        private String schoolName;

        @NotNull(message = "Start date cannot be null")
        private LocalDateTime startDate;

        @NotNull(message = "End date cannot be null")
        private LocalDateTime endDate;
    }
}
