package com.sbilh.bank.SBIWEBSITE.login.dto;

import com.sbilh.bank.SBIWEBSITE.login.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "/user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
    @ManyToMany
    private Collection<Role> roles = new ArrayList<>();
}
