package com.toufu.factory.media.blog.services;

import com.toufu.factory.media.blog.model.Tag;
import com.toufu.factory.media.blog.repositries.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public Iterable<String> getPublishedTag(){
        return tagRepository.getPublishedTag();
    }
}
