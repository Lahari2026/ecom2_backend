package com.angularspringbootecommerce.backend.models;

import jakarta.persistence.*;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Setter
@Entity
@Table(name = "user_roles")
public class UserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="role_id")
    private Long id;

    private String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserRole() {
        super();
    }

    public UserRole(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    public UserRole(Long id, String authority, User user) {
        this.id = id;
        this.authority = authority;
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

}
