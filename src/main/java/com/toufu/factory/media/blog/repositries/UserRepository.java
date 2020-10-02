package com.toufu.factory.media.blog.repositries;

import com.toufu.factory.media.blog.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}