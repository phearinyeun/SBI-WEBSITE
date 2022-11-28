package com.sbilh.bank.SBIWEBSITE.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

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
//    @JsonProperty("job_title")
    private String jobTitle;

    @Column(name = "expired_date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dateExpired;
//    private String dateExpired;

    @Column(name = "position")
    private String position;

    @Column(name = "unit",nullable = false)
    private String unit;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "reporting_to", nullable = false)
    private String reporting_to;

    @Column(name ="locations")
    private String location;

    @Column(name = "job_purpose" , nullable = false)
    private String job_purpose;

    @Column(name = "duties_and_responsibilities", nullable = false)
    private String duties_and_responsibilities;

    @Column(name = "qualification", nullable = false)
    private String qualification;

}
