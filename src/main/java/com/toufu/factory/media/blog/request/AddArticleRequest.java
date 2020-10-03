package com.toufu.factory.media.blog.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class AddArticleRequest {
    private Integer id;
    private String title;
    private String content;
    private Boolean published;
    private String category;
    private List<String> tags;
}
