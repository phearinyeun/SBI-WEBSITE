package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.CarrerModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarrerRepository extends JpaRepository<CarrerModel, Long> {
    Optional<CarrerModel> findByJobTitle(String title);
    @Query("SELECT j FROM CarrerModel j WHERE j.jobTitle =:jobTitle")
    List<CarrerModel> findAllByJobTitle (String jobTitle, Pageable pageable);

}
