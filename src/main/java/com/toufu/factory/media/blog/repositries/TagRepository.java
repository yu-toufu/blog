package com.toufu.factory.media.blog.repositries;

import com.toufu.factory.media.blog.model.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag,String> {

    @Query(value = "SELECT tags_name FROM article INNER JOIN article_tags ON article.id = article_tags.articles_id WHERE published = true;", nativeQuery = true)
    List<String> getPublishedTag();
}
