package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarrerRepository extends JpaRepository<CarrerModel, Long> {
    Optional<CarrerModel> findByJobTitle(String title);
    List<CarrerModel> findAllByJobTitle(String jobTitle, Pageable pageable);
    CarrerModel deleteByJobId (Long jobid);
}
