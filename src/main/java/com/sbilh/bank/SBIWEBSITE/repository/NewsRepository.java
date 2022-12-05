package com.sbilh.bank.SBIWEBSITE.repository;

import com.sbilh.bank.SBIWEBSITE.model.NewsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsModel, Long> {
}
