package com.toufu.factory.media.blog.controllers;

import com.toufu.factory.media.blog.model.Article;
import com.toufu.factory.media.blog.request.AddArticleRequest;
import com.toufu.factory.media.blog.request.DeleteArticleRequest;
import com.toufu.factory.media.blog.response.ArticleResponse;
import com.toufu.factory.media.blog.services.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping(path="/article/add")
    public @ResponseBody ArticleResponse addNewArticle (@RequestBody @Valid AddArticleRequest request) {
        Article article = articleService.add(request);
        return new ArticleResponse(article);
    }

    @PostMapping(path="/article/update")
    public @ResponseBody ArticleResponse updateArticle (@RequestBody @Valid AddArticleRequest request) {
        Article article = articleService.update(request);
        return new ArticleResponse(article);
    }

    @PostMapping(path="/article/delete")
    public void deleteArticle (@RequestBody @Valid DeleteArticleRequest request) {
        articleService.delete(request);
    }

    @PostMapping(path="/image/upload")
    public String uploadImage(@RequestParam("uploadFile")MultipartFile multipartFile){
        return "";
    }

    @GetMapping(path="/article/all")
    public @ResponseBody List<ArticleResponse> getAllArticle() {
        List<ArticleResponse> response = new ArrayList<>() ;
        articleService.findAll().forEach((article -> {
            response.add(new ArticleResponse(article));
        }));
        return response;
    }

    @GetMapping(path="/article/published")
    public @ResponseBody List<ArticleResponse> getPublishedArticle() {
        List<ArticleResponse> response = new ArrayList<>() ;
        articleService.findPublishedArticle().forEach((article -> {
            response.add(new ArticleResponse(article));
        }));
        return response;
    }

    @GetMapping(path="/article/category/{name}")
    public @ResponseBody List<ArticleResponse> getCategoryArticle(@PathVariable String name) {
        List<ArticleResponse> response = new ArrayList<>();
        articleService.findCategory(name).forEach((article -> {
            response.add(new ArticleResponse(article));
        }));
        return response;
    }

    @GetMapping(path="/article/tag/{name}")
    public @ResponseBody List<ArticleResponse> getTagArticle(@PathVariable String name) {
        List<ArticleResponse> response = new ArrayList<>();
        articleService.findTag(name).forEach((article -> {
            response.add(new ArticleResponse(article));
        }));
        return response;
    }

    @GetMapping(path="/article/{id}")
    public @ResponseBody ArticleResponse getCategoryArticle(@PathVariable Integer id) {
        Article article = articleService.findArticle(id);
        return new ArticleResponse(article);
    }


}
