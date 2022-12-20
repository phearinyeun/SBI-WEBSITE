package com.sbilh.bank.SBIWEBSITE.login.repo;

import com.sbilh.bank.SBIWEBSITE.login.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
