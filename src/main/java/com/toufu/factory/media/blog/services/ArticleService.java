package com.toufu.factory.media.blog.services;

import com.toufu.factory.media.blog.exception.ArticleNotFoundException;
import com.toufu.factory.media.blog.model.Article;
import com.toufu.factory.media.blog.model.Category;
import com.toufu.factory.media.blog.model.Tag;
import com.toufu.factory.media.blog.repositries.ArticleRepository;
import com.toufu.factory.media.blog.repositries.CategoryRepository;
import com.toufu.factory.media.blog.repositries.TagRepository;
import com.toufu.factory.media.blog.request.AddArticleRequest;
import com.toufu.factory.media.blog.request.DeleteArticleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService {
    @Autowired // This means to get the bean called userRepository
    private ArticleRepository articleRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Article add(AddArticleRequest request){
        Category category = categoryRepository.findById(request.getCategory()).orElse(Category.builder().name(request.getCategory()).build());
        Set<Tag> tags = new HashSet<Tag>();
        for(String t : request.getTags()){
            Tag tag = tagRepository.findById(t).orElse(Tag.builder().name(t).build());
            tags.add(tag);
        }
        Article article = Article.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .published(request.getPublished())
                .category(category)
                .tags(tags)
                .build();
        articleRepository.save(article);
        return article;
    }

    public Article update(AddArticleRequest request){
        Optional<Article> articleOptional = articleRepository.findById(request.getId());
        articleOptional.orElseThrow( ()->new ArticleNotFoundException("resource not found. id:" + request.getId()));
        Article article = articleOptional.get();

        Category category = categoryRepository.findById(request.getCategory()).orElse(Category.builder().name(request.getCategory()).build());
        Set<Tag> tags = new HashSet<>();
        for(String t : request.getTags()){
            Tag tag = tagRepository.findById(t).orElse(Tag.builder().name(t).build());
            tags.add(tag);
        }
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setPublished(request.getPublished());
        article.setTags(tags);
        article.setCategory(category);
        articleRepository.save(article);
        return article;
    }

    public void delete(DeleteArticleRequest request){
        Optional<Article> articleOptional= articleRepository.findById(request.getId());
        articleOptional.ifPresent(article -> {
            for(Tag t :article.getTags()){
                article.getTags().remove(t);
            }
            articleRepository.delete(article);
        });
    }
    public Article findArticle(Integer id){
        Optional<Article> optionalArticle = articleRepository.findById(id);
        optionalArticle.orElseThrow( ()->new ArticleNotFoundException("resource not found. id:" + id));
        Article article = optionalArticle.get();
        return article;
    }

    public Iterable<Article> findAll(){
        Iterable<Article> articles = articleRepository.findAll();
        return articles;
    }

    public Iterable<Article> findPublishedArticle(){
        Iterable<Article> articles = articleRepository.findByPublished(true);
        return articles;
    }

    public Iterable<Article> findTag(String tagName){
        Tag tag = Tag.builder().name(tagName).build();
        Iterable<Article> articles = articleRepository.findByTags(tag);
        return articles;
    }
    public Iterable<Article> findCategory(String categoryName){
        Category category = Category.builder().name(categoryName).build();
        Iterable<Article> articles = articleRepository.findByCategory(category);
        return articles;
    }
}
