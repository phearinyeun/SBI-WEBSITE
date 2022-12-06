package com.sbilh.bank.SBIWEBSITE.service;

import com.sbilh.bank.SBIWEBSITE.model.NewsModel;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    NewsModel addNews (NewsModel newsModel);
    NewsModel updateNews (NewsModel newsModel, Long id);
    List<NewsModel> findAllNews();
    NewsModel deleteById(Long id);
}
