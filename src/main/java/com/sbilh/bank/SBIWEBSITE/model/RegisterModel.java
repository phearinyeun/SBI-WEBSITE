package com.sbilh.bank.SBIWEBSITE.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "registration")
public class RegisterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "First Name can not empty")
    @Column(name = "firstname", length = 50)
    private String firstname;

    @NotEmpty(message = "Last Name can not empty")
    @Column(name = "lastname", length = 50)
    private String lastname;

    @NotEmpty(message = "Email can not empty")
    @Email
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Password can not empty")
    @Column(name = "password")
    private String password;

    @NotEmpty(message = "Matching Password can not empty")
    private String matchingPassword;

}
