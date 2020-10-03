package com.toufu.factory.media.blog.controllers;

import com.toufu.factory.media.blog.repositries.TagRepository;
import com.toufu.factory.media.blog.response.CategoryResponse;
import com.toufu.factory.media.blog.response.TagResponse;
import com.toufu.factory.media.blog.services.TagService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping(path="/tag/all")
    public @ResponseBody
    List<TagResponse> getAllArticle() {
        List<TagResponse> response = new ArrayList<>();
        tagService.getPublishedTag().forEach((tag -> {
            response.add(new TagResponse(tag));
        }));
        return response;
    }
}
