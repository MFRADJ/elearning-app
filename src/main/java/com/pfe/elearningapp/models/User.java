package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.time.LocalDateTime;

import com.pfe.elearningapp.enmus.UserStatus;
import com.pfe.elearningapp.enmus.UserRole;

import static org.springframework.security.crypto.encrypt.Encryptors.*;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {
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

    /** password encoder */
    @Autowired
    private transient PasswordEncoder passwordEncoder;

    /**
     * Sets the password after encoding it.
     * @param password the raw password to encode and set
     */
    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }

    /* Tow facotr encrypter with specifec getters and setters */

    private static final String ENCRYPT_KEY = "aabb09182736ccdd";
    private static final String SALT = "f2b56b8f04b24dfb";

    @Column(nullable = true)
    private String encryptedTwoFactorSecret;

    @Column(nullable = false)
    private boolean isTwoFactorEnabled = false;

    @Column(nullable = false)
    private int failedLoginAttempts = 0;

    @Column(nullable = false)
    private LocalDateTime lastLoginDate;

    @Column(nullable = true)
    private String encryptedApiKey;

    @Transient
    private TextEncryptor encryptor = Encryptors.delux(ENCRYPT_KEY, SALT);

    public void setTwoFactorSecret(String twoFactorSecret) {
        this.encryptedTwoFactorSecret = encryptor.encrypt(twoFactorSecret);
    }

    public String getTwoFactorSecret() {
        return encryptor.decrypt(this.encryptedTwoFactorSecret);
    }

    public void setApiKey(String apiKey) {
        this.encryptedApiKey = encryptor.encrypt(apiKey);
    }

    public String getApiKey() {
        return encryptor.decrypt(this.encryptedApiKey);
    }


    /* user roles and Status */
    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<UserRole> roles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status = UserStatus.ACTIVE;

    /* preference user ex. language ..*/
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_preferences", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "key")
    @Column(name = "value")
    private Map<String, String> preferences = new HashMap<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Profile profile;


}
