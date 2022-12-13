package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.exception.NotFoundException;
import com.sbilh.bank.SBIWEBSITE.exception.respone.Response;
import com.sbilh.bank.SBIWEBSITE.model.NewsModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.NewsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/news")
public class NewsController {
    public final NewsServiceImpl newsServiceimpl;
    public NewsController(NewsServiceImpl newsServiceimpl) {
        this.newsServiceimpl = newsServiceimpl;
    }

    @GetMapping
    public Response findAll(NewsModel newsModel){
        List<NewsModel> newsModels = newsServiceimpl.findAll();
        log.info("Success found by News {}", newsModels);
        return new Response(200,"Sucess", newsModels);
    }

    @GetMapping("find/{id}")
    public Response findById(@PathVariable ("id") Long id){
        Optional<NewsModel> newsModelOptional = newsServiceimpl.findById(id);
        if (newsModelOptional.isPresent()){
            log.info("Success find By ID {}", id);
            return new Response (200, "Success find By ID", newsModelOptional);
        }
        throw new NotFoundException(id, "Could not found by ID " + id.toString());
    }

    @PostMapping
    public Response add(@RequestBody @Valid NewsModel newsModel){
        newsServiceimpl.add(newsModel);
        log.info("News Addes {} ", newsModel);
        return new Response(200, "News Added ", newsModel);
    }

    @PostMapping("/delete/{id}")
    public Optional<NewsModel> deleteById(@PathVariable("id") Long id){
        newsServiceimpl.deleteById(id);
        return null;
    }

    @PostMapping("/update/{id}")
    public NewsModel updateNews (@PathVariable ("id") Long id, @RequestBody NewsModel newsModel){
        return newsServiceimpl.update(newsModel,id);
    }
}
