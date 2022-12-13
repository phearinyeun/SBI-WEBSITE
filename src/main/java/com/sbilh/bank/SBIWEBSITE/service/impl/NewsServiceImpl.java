package com.sbilh.bank.SBIWEBSITE.service.impl;

import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
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
    public List<NewsModel> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<NewsModel> findById(Long id) {
        return newsRepository.findById(id);
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
        Response response  = new Response();

        try{
            if(newsRepository.findById(id).isEmpty()) return false;
            newsRepository.deleteById(id);
            return new Response(200,"Sucess deleted ID :", );
        }catch (Exception e){
            log.error("error delete id: {} , message: {}",id,e.getMessage());
            throw new  NotFoundException(id, "Coudl not delete by ID");
        }
    }

}
