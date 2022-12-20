package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.UserLoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<UserLoginModel, Long> {

//    @Query("SELECT f FROM RegisterModel f WHERE f.firstName =:firstName")
    @Query("SELECT n FROM RegisterModel n WHERE n.firstName =:firstName and n.lastName =:lastName")
    List<UserLoginModel> findFirstname(String firstName, String lastName);

}
