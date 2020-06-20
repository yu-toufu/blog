package com.toufu.factory.media.blog.repositries;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
public class Article {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Integer articleNumber;
    @NotNull
    private String title;

    private String content;

    private Boolean published;

    private Date createDate;

    @ManyToOne
    private User createdUser;

    private Date updatedDate;

    @ManyToOne
    private User updatedUser;
}
