package com.sbilh.bank.SBIWEBSITE.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "branches")
public class BranchesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    String category;
    String name;
    String telephone;
    String image;
    double latlong;
    boolean isHq;
}
