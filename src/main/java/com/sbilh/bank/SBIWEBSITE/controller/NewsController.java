package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.NewsModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.NewsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/news")
public class NewsController {
    public final NewsServiceImpl newsServiceimpl;
    public NewsController(NewsServiceImpl newsServiceimpl) {
        this.newsServiceimpl = newsServiceimpl;
    }

//    Add News
    @PostMapping
    public NewsModel newsModel (@RequestBody @Valid NewsModel newsModel){
        return newsServiceimpl.createNews(newsModel);
    }
//    Find All News
    @GetMapping
    public List<NewsModel> findAllNews(){
        return newsServiceimpl.findAllNews();
    }

    @PostMapping("/delete/{id}")
    public NewsModel deleteById(@PathVariable("id") Long id){
        newsServiceimpl.deleteById(id);
        return null;
    }
}
