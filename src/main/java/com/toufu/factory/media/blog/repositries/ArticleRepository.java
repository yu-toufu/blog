package com.toufu.factory.media.blog.repositries;

import com.toufu.factory.media.blog.model.Article;
import com.toufu.factory.media.blog.model.Category;
import com.toufu.factory.media.blog.model.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article,Integer>{
    List<Article> findByTags(Tag tag);
    List<Article> findByCategory(Category category);
    List<Article> findByPublished(Boolean published);

    @Query(value = "SELECT count(*) AS count, category_name AS categoryName FROM article WHERE published = true GROUP BY category_name;", nativeQuery = true)
    List<ResultCountGroupBy> getCountGroupByCategory();

    public static interface ResultCountGroupBy{
        public String getCategoryName();
        public Integer getCount();
    }
}
