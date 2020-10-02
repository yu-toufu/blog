package com.toufu.factory.media.blog;

import com.toufu.factory.media.blog.controllers.ArticleController;
import com.toufu.factory.media.blog.response.ArticleResponse;
import com.toufu.factory.media.blog.services.ArticleService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleControllerTest {

    @Mock
    private ArticleService articleService;

    @InjectMocks
    @Autowired
    private ArticleController articleController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void test() throws Exception{
        if (articleController == null){
            System.out.println("***");
        }
        ArticleResponse response = articleController.getAllArticle();
    }
}
