package com.sbilh.bank.SBIWEBSITE.controller;

import com.sbilh.bank.SBIWEBSITE.model.NewsModel;
import com.sbilh.bank.SBIWEBSITE.service.impl.NewsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    public final NewsServiceImpl newsServiceimpl;
    public NewsController(NewsServiceImpl newsServiceimpl) {
        this.newsServiceimpl = newsServiceimpl;
    }


    @PostMapping
    public ResponseEntity<NewsModel>addNews(@RequestBody @Valid NewsModel newsModel){
        return ResponseEntity.ok() .body(newsServiceimpl.addNews(newsModel));
    }

    @GetMapping
    public ResponseEntity<List<NewsModel>> findAllNews(){
        return ResponseEntity.ok() .body(newsServiceimpl.findAllNews());
    }

    @PostMapping("/delete/{id}")
    public NewsModel deleteById(@PathVariable("id") Long id){
        newsServiceimpl.deleteById(id);
        return null;
    }
    @PutMapping("/update/{id}")
    public NewsModel updateNews (@PathVariable ("id") Long id, @RequestBody NewsModel newsModel){
        return newsServiceimpl.updateNews(newsModel,id);

    }
}
