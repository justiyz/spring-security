package com.springsecurity.springsecurity.data.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private boolean isActive;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(value = EnumType.STRING)
    private List<Roles> roles;
}
