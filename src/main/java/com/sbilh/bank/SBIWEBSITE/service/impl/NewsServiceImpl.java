package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.model.NewsModel;
import com.sbilh.bank.SBIWEBSITE.repository.NewsRepository;
import com.sbilh.bank.SBIWEBSITE.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class NewsServiceImpl implements NewsService {
    public final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public NewsModel addNews (NewsModel newsModel) {
        log.info("Adding News {} to news {}", newsModel);
        return newsRepository.save(newsModel);
    }
    @Override
    public NewsModel updateNews (NewsModel newsModel, Long id) {
        Optional<NewsModel> newsModelOptional = newsRepository.findById(id);
        if (newsModelOptional.isPresent()){
            newsModel.setId(id);
            newsRepository.save(newsModel);
            log.info("Carrer is update {} ", newsModel);

            return newsModel;
        }
        return null;
    }
    @Override
    public List<NewsModel> findAllNews() {
        return newsRepository.findAll();
    }
    @Override
    public NewsModel deleteById(Long id) {
        log.info("Deleted News By Id {}", id);
        newsRepository.deleteById(id);
        return null;
    }
}
