package com.toufu.factory.media.blog.repositries;

import com.toufu.factory.media.blog.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,String> {


}
