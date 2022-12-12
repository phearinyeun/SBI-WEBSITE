package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterModel, Long> {

//    @Query("SELECT f FROM RegisterModel f WHERE f.firstName =:firstName")
    @Query("SELECT n FROM RegisterModel n WHERE n.firstName =:firstName and n.lastName =:lastName")
    List<RegisterModel> findFirstname(String firstName, String lastName);

}
