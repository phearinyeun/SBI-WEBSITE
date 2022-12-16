package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
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
    public List<NewsModel> findAll(NewsModel newsModel) {
        log.info("Success found by News {}", newsModel);
        return newsRepository.findAll();
    }

    @Override
    public Optional<NewsModel> findById(Long id) {
        Optional<NewsModel> newsModelOptional = newsRepository.findById(id);
        if (newsModelOptional.isPresent()){
            log.info("Success find By ID {}", newsModelOptional);
            return newsRepository.findById(id);
        }
        log.info("Could not found by ID: ",id);
        throw new NotFoundException(id, "Could not found by ID " + id.toString());
    }

    @Override
    public NewsModel add(NewsModel newsModel) {
        log.info("Adding News {} to news {}", newsModel);
        return newsRepository.save(newsModel);
    }
    @Override
    public NewsModel update (NewsModel newsModel, Long id) {
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
    public boolean deleteById(Long id) {
        Optional<NewsModel> newsModelOptional = newsRepository.findById(id);
        if (newsModelOptional.isPresent()) {
            newsRepository.deleteById(id);
            log.info("Success deleted by ID: {}", id);
            return true;
        }
        log.info("Could not found the ID {}", id);
        throw new NotFoundException(id, "Could not found the ID: ", id.toString());
    }

//        try{
//            if(newsRepository.findById(id).isEmpty()) return false;
//            newsRepository.deleteById(id);
//        }catch (Exception e){
//            log.error("error delete id: {} , message: {}",id,e.getMessage());
//            throw new  NotFoundException(id, "Coudl not delete by ID");
//        }
//        return true;

}
