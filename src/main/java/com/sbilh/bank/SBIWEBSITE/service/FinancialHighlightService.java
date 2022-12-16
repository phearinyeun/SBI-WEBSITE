package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.FinancialHighlightModel;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.List;
import java.util.Optional;

public interface FinancialHighlightService {
    FinancialHighlightModel create (FinancialHighlightModel financialHighlightModel);
    List<FinancialHighlightModel> findAll(FinancialHighlightModel financialHighlightModel);
    Optional<FinancialHighlightModel> findById (Long id);
    void deleteById(Long id);
    FinancialHighlightModel update (FinancialHighlightModel financialHighlightModel ,Long id);
}
