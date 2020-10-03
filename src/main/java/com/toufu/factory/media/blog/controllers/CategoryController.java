package com.toufu.factory.media.blog.controllers;

import com.toufu.factory.media.blog.repositries.CategoryRepository;
import com.toufu.factory.media.blog.response.ArticleResponse;
import com.toufu.factory.media.blog.response.CategoryResponse;
import com.toufu.factory.media.blog.services.ArticleService;
import com.toufu.factory.media.blog.services.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(path="/category/all")
    public @ResponseBody
    List<CategoryResponse> getAllArticle() {
        List<CategoryResponse> response = new ArrayList<>() ;
        categoryService.findAll().forEach((category -> {
            response.add(new CategoryResponse(category));
        }));
        return response;
    }

}
