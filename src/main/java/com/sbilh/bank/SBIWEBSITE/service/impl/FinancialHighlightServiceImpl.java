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
        Optional<FinancialHighlightModel> financialHighlightModelList = financialHighlightRepository.findById(id);
            if (financialHighlightModelList.isPresent()){
                log.info("Success found by ID {} ", id);
                return financialHighlightModelList;
            }
                log.info("Can't find by ID {} :", id);
                throw new NotFoundException(id, "Can't find by ID " ,id.toString());
    }

    @Override
    public Long deleteById(Long id) {
        log.info("Success deleted by id {} ", id);
       financialHighlightRepository.deleteById(id);
        throw new NotFoundException(id,"Could not found the id: ", id.toString());
    }

    @Override
    public FinancialHighlightModel update(FinancialHighlightModel financialHighlightModel, Long id) {
          Optional<FinancialHighlightModel> financialHighlightModelOptional= financialHighlightRepository.findById(id);
        if (financialHighlightModelOptional.isPresent()) {
            log.info("Success update {}",  financialHighlightModel);
            financialHighlightModel.setId(id);
            financialHighlightRepository.save(financialHighlightModel);
            return financialHighlightModel;
        }
        log.info("Could not found the ID {} ", id);
        throw new  NotFoundException(id,"Could not found the ID :", id.toString());
    }
}
