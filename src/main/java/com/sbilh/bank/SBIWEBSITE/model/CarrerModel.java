package com.sbilh.bank.SBIWEBSITE.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carrer")
public class CarrerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty()
    @Column(name = "job_title", nullable = false)
    @JsonProperty("job_title")
    private String jobTitle;

    @Column(name = "unit")
    private String unit;

    @Column(name = "department")
    private String department;

    @Column(name = "reporting_to")
    private String reporting_to;

    @Column(name = "head_quarter")
    private String head_quarter;

    @Column(name = "job_purpose")
    private String job_purpose;

    @Column(name = "duties_and_responsibilities")
    private String duties_and_responsibilities;

    @Column(name = "qualification")
    private String qualification;

}
