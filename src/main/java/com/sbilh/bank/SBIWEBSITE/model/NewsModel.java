package com.sbilh.bank.SBIWEBSITE.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news")
public class NewsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    @Column(name = "title", length = 255)
    @NotNull
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "read_more")
    private String readMore;
}
