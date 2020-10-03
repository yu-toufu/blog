package com.toufu.factory.media.blog.response;

import com.toufu.factory.media.blog.repositries.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryResponse {
    private String name;
    private Integer count;

    public CategoryResponse(ArticleRepository.ResultCountGroupBy r){
        this.name = r.getCategoryName();
        this.count= r.getCount();
    }
}
