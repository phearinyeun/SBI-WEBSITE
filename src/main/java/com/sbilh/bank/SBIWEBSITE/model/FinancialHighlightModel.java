package com.sbilh.bank.SBIWEBSITE.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Financial_Highlight")
public class FinancialHighlightModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "aboutTheBank")
    private String aboutTheBank;

    @Column(name = "financial_Highlight")
    private String financialHighlight;

}
