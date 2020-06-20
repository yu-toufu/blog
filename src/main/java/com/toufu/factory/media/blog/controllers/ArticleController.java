package com.toufu.factory.media.blog.controllers;

import com.toufu.factory.media.blog.repositries.Article;
import com.toufu.factory.media.blog.repositries.ArticleRepository;
import com.toufu.factory.media.blog.response.ArticleResponse;
import com.toufu.factory.media.blog.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping(path="/article/add") // Map ONLY POST Requests
    public @ResponseBody ArticleResponse addNewArticle (@RequestBody @Valid Article article) {
        articleService.add(article);
        ArticleResponse response = ArticleResponse.builder()
                .articles(Collections.singletonList(article))
                .build();
        return response;
    }

    @GetMapping(path="/article/all")
    public @ResponseBody ArticleResponse getAllArticle() {
        Iterable<Article> articles = articleService.findAll();
        ArticleResponse response = ArticleResponse.builder()
                .articles(articles)
                .build();
        return response;
    }
}
