package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "profiles")
public class profile {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private user user;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Lob
    private String bio;

    // Standard getters and setters...
}
