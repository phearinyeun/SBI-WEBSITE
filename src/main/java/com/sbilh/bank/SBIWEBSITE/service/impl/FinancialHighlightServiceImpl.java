package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
import com.sbilh.bank.SBIWEBSITE.model.FinancialHighlightModel;
import com.sbilh.bank.SBIWEBSITE.repository.FinancialHighlightRepository;
import com.sbilh.bank.SBIWEBSITE.service.FinancialHighlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FinancialHighlightServiceImpl implements FinancialHighlightService {
    private final FinancialHighlightRepository financialHighlightRepository;

    public FinancialHighlightServiceImpl(FinancialHighlightRepository financialHighlightRepository) {
        this.financialHighlightRepository = financialHighlightRepository;
    }

    @Override
    public FinancialHighlightModel create(FinancialHighlightModel financialHighlightModel) {
        log.info("Success create Financial Highlight {} ", financialHighlightModel);
       return financialHighlightRepository.save(financialHighlightModel);

    }

    @Override
    public List<FinancialHighlightModel> findAll (FinancialHighlightModel financialHighlightModel) {
        log.info("Success get all financial : {}", financialHighlightModel);
        return financialHighlightRepository.findAll();
    }

    @Override
    public Optional<FinancialHighlightModel> findById(Long id){
        return null;
//        financialHighlightRepository.findAll();
//        if (findA.isEmpty())){
//            financialHighlightRepository.findById(id);
//        }
//        throw new NotFoundException(id, "Can't find by ID " ,id.toString());
    }

    @Override
    public Optional<FinancialHighlightModel> deleteById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<FinancialHighlightModel> update(FinancialHighlightModel financialHighlightModel) {
        return Optional.empty();
    }
}
