package com.sbilh.bank.SBIWEBSITE.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @NotEmpty
    @NotEmpty
    private String firstname;

    @NotEmpty
    @NotEmpty
    private String lastname;

    @NotEmpty
    @NotEmpty
    private String email;

    @NotEmpty
    @NotEmpty
    private String password;
    private String matchingPassword;

}
