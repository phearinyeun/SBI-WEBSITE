package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
import com.sbilh.bank.SBIWEBSITE.model.MobileBankingModel;
import com.sbilh.bank.SBIWEBSITE.repository.MobileBankingRepository;
import com.sbilh.bank.SBIWEBSITE.service.MobileBankingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MobileBankingServiceImpl implements MobileBankingService {
    private final MobileBankingRepository mobileBankingRepository;

    public MobileBankingServiceImpl(MobileBankingRepository mobileBankingRepository) {
        this.mobileBankingRepository = mobileBankingRepository;
    }

    @Override
    public MobileBankingModel create(MobileBankingModel mobileBankingModel) {
        log.info("Success create ", mobileBankingModel);
        return mobileBankingRepository.save(mobileBankingModel);
    }

    @Override
    public Optional<MobileBankingModel> update(MobileBankingModel mobileBankingModel ,Long id) {
        Optional<MobileBankingModel> mobileBankingModelOptional = mobileBankingRepository.findById(id);
        if (mobileBankingModelOptional.isPresent()){
            mobileBankingModel.setId(id);
            mobileBankingRepository.save(mobileBankingModel);
            log.info("Success update {}", mobileBankingModel);
            return mobileBankingModelOptional;
        }
        log.info("Could not found id {}", id);
        throw new NotFoundException(id,"Could not found the ID :", id.toString());
    }

    @Override
    public boolean deleteById(Long id) {
         Optional<MobileBankingModel> mobileBankingModel = mobileBankingRepository.findById(id);
        if (mobileBankingModel.isPresent()){
            log.info("Success deleted id {}", id);
            mobileBankingRepository.deleteById(id);
            return true;
        }
        log.info("Could not found id {}", id);
        throw new NotFoundException(id, "Could not found id",id.toString());
    }

    @Override
    public List<MobileBankingModel> findAll(MobileBankingModel mobileBankingModel) {
        return mobileBankingRepository.findAll();
    }

    @Override
    public Optional<MobileBankingModel> findById(Long id) {
        if (mobileBankingRepository.findById(id).isPresent()) {
            log.info("Success get id by id {}", id);
            return mobileBankingRepository.findById(id);
        }
        log.info("Could not found id {}", id);
        throw new NotFoundException (id,"Could not found id :", id.toString());
    }

    @Override
    public List<MobileBankingModel> findByName(String name) {
        List<MobileBankingModel> mobileBankingModels = mobileBankingRepository.findByName(name);
        if(!mobileBankingModels.isEmpty()){
            log.info("Success get by Name {}", mobileBankingModels);
            return mobileBankingRepository.findByName(name);
        }
        log.info("Could nof found get by Name {};", mobileBankingModels);
        throw new NotFoundException(name, "Could not found the name ", name);
    }
}
