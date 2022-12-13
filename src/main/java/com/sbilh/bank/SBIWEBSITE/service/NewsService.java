package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.NewsModel;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    List <NewsModel> findAll();
    Optional<NewsModel> findById(Long id);
    NewsModel add (NewsModel newsModel);
    NewsModel update (NewsModel newsModel, Long id);
    boolean deleteById(Long id);
}
