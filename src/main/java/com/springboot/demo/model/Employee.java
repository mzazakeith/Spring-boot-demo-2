package com.springboot.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
//   names should not be null or empty and should be at least 2 characters
    @NotEmpty
    @Size(min =2, message="should be at least 2 characters")
    private String firstName;

    @NotEmpty
    @Size(min =2, message="should be at least 2 characters")
    @Column(name = "last_name")
    private String lastName;

//    email should be valid and should not be empty
    @NotEmpty
    @Email
    @Column(name="email")
    private String email;
}
