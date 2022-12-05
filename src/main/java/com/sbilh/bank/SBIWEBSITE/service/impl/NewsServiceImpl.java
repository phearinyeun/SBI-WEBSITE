package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.model.NewsModel;
import com.sbilh.bank.SBIWEBSITE.repository.NewsRepository;
import com.sbilh.bank.SBIWEBSITE.service.NewsService;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
    public final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public NewsModel createNews (NewsModel newsModel) {
        return newsRepository.save(newsModel);
    }


}
