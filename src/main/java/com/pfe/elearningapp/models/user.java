package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @NotEmpty
    @Size(max = 100)
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8, max = 100) // Ensure password length is adequate
    private String password;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;  // For logical deletion

    @Column(nullable = true)
    private String twoFactorSecret;

    @Column(nullable = false)
    private boolean isTwoFactorEnabled = false;

    @Column(nullable = false)
    private boolean isAccountNonLocked = true;

    @Column(nullable = false)
    private int failedLoginAttempts = 0;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

    @Column(nullable = true)
    private String apiKey;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_preferences", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "key")
    @Column(name = "value")
    private Map<String, String> preferences = new HashMap<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Profile profile;

    /**
     * Sets the password after encoding it.
     * @param password the raw password to encode and set
     */
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
