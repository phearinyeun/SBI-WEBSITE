package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterModel, Long> {
    RegisterModel create(RegisterModel registerModel);
}
