package com.toufu.factory.media.blog.response;

import com.toufu.factory.media.blog.repositries.Article;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ArticleResponse {
    private Iterable<Article> articles;
}
