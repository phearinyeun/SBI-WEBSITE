package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.NewsModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.NewsServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/news")
public class NewsController {
    public final NewsServiceImpl newsServiceimpl;
    public NewsController(NewsServiceImpl newsServiceimpl) {
        this.newsServiceimpl = newsServiceimpl;
    }

    @PostMapping
    public NewsModel newsModel (@RequestBody @Valid NewsModel newsModel){
        return newsServiceimpl.createNews(newsModel);
    }
}
