package com.toufu.factory.media.blog.services;

import com.toufu.factory.media.blog.repositries.Article;
import com.toufu.factory.media.blog.repositries.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired // This means to get the bean called userRepository
    private ArticleRepository articleRepository;

    public Article add(Article article){
        articleRepository.save(article);
        return article;
    }

    public Iterable<Article> findAll(){
        return articleRepository.findAll();
    }
}
