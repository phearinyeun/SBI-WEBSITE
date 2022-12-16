package com.sbilh.bank.SBIWEBSITE.controller;

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
        return new Response(200,"Sucess found News ", newsServiceimpl.findAll(newsModel));
    }

    @GetMapping("find/{id}")
    public Response findById(@PathVariable ("id") Long id){
        return new Response(200, "Success find by ID", newsServiceimpl.findById(id));
    }

    @PostMapping
    public Response add(@RequestBody @Valid NewsModel newsModel){
        newsServiceimpl.add(newsModel);
        return new Response(200, "News Added ", newsModel);
    }


    @PostMapping("/delete/{id}")
    public Response deleteById(@PathVariable("id") Long id){
        newsServiceimpl.deleteById(id);
        return new Response(200, "Success deleted by ID :", id);
    }

    @PostMapping("/update/{id}")
    public Response update (@RequestBody NewsModel newsModel, @PathVariable ("id") Long id){
        newsServiceimpl.findAll(newsModel);
        return new Response(200, "Success updated news :", newsModel);

    }
}
