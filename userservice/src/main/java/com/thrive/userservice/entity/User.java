package com.thrive.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String username;
    private String password;
    private String email;
    private String mobileNumber;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}