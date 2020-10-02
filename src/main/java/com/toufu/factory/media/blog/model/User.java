package com.toufu.factory.media.blog.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NonNull
    private String name;

    private String email;

    private String info;

    private String githubUrl;

    private String twitterUrl;

    private Boolean admin;

    private Boolean owner;
    private Date createDate;

    private Date updatedDate;

    @PrePersist
    private void prePersist(){
        setCreateDate(new Date());
        setUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate(){
        setUpdatedDate(new Date());
    }
}
