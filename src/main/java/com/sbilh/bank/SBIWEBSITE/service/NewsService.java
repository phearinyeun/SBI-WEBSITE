package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.NewsModel;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    NewsModel createNews (NewsModel newsModel);
    List<NewsModel> findAllNews();
    NewsModel deleteById(Long id);
}
