package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.MobileBankingModel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MobileBankingService {
    MobileBankingModel create (MobileBankingModel mobileBankingModel);
    Optional<MobileBankingModel> update (MobileBankingModel mobileBankingModel ,Long id);
    boolean deleteById (Long id);
    List<MobileBankingModel> findAll(MobileBankingModel mobileBankingModel);
    Optional<MobileBankingModel> findById(Long id);
    List<MobileBankingModel> findByName(String name);

}
