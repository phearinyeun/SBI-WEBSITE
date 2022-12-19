package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.MobileBankingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MobileBankingRepository extends JpaRepository<MobileBankingModel, Long> {
//    @Query("SELECT m FROM MobileBankingModel m WHERE m.name LIKE %:name%")
//    @Query("SELECT n FROM MobileBankingModel n WHERE n.name =:name")

    List<MobileBankingModel> findByName(String name);
}
