package com.sbilh.bank.SBIWEBSITE.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Mobile_Banking")
@Entity
public class MobileBankingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_mobileBanking")
    @SequenceGenerator(name = "sequence_mobileBanking", allocationSize = 1)
    private Long Id;

    @Column(name = "name")
    @NotNull
    @NotEmpty
    String name;

    @NotNull
    @NotEmpty
    @Column(name = "description")
    String description;

    @NotNull
    @NotEmpty
    @Column(name = "image")
    String image;
}
