package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<RegisterModel, Long> {
}
