package com.hersafety.hersafety.DTO;

import java.time.Instant;
import java.time.LocalDate;

import com.hersafety.hersafety.model.Role;

import jakarta.persistence.Enumerated;

public class UserResponse {

    private String username;
    private String name;
    private LocalDate dateOfBirth;    
    private String email;
    private boolean notifications;
    private Instant createdAt;
    private Role role;
    
    
    public UserResponse(String username, String name, LocalDate dateOfBirth, String email, boolean notifications,
            Instant createdAt, Role role) {
        this.username = username;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.notifications = notifications;
        this.createdAt = createdAt;
        this.role = role;
    }
    
    public UserResponse() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isNotifications() {
        return notifications;
    }
    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
