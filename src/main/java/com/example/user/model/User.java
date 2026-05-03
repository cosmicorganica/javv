package com.example.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String phone;

    public User() {}

    public User(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
