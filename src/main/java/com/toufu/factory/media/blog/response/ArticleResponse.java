package com.toufu.factory.media.blog.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.toufu.factory.media.blog.model.Article;
import com.toufu.factory.media.blog.model.Category;
import com.toufu.factory.media.blog.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleResponse {
    private Integer id;
    private String title;
    private String content;
    private Boolean published;
    private String category;
    private List<String> tags;
    private Date createdDate;
    private Date publishDate;
    private Date updatedDate;

    public ArticleResponse(Article article){
        this.id=article.getId();
        this.title=article.getTitle();
        this.content=article.getContent();
        this.published=article.getPublished();
        this.category=article.getCategory().getName();
        this.tags=new ArrayList<String>();
        article.getTags().forEach(tag -> {
           this.tags.add(tag.getName());
        });
        this.createdDate=article.getCreatedDate();
        this.updatedDate=article.getUpdatedDate();
    }
}
