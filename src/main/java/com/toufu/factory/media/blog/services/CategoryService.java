package com.toufu.factory.media.blog.services;

import com.toufu.factory.media.blog.model.Category;
import com.toufu.factory.media.blog.repositries.ArticleRepository;
import com.toufu.factory.media.blog.repositries.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleRepository.ResultCountGroupBy> findAll(){
       List<ArticleRepository.ResultCountGroupBy> results = articleRepository.getCountGroupByCategory();
        return results;
    }
}
