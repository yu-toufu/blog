package com.toufu.factory.media.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id
    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonBackReference
    private List<Article> articles;

    private Date createdDate;

    private Date updatedDate;

    @PrePersist
    private void prePersist(){
        setCreatedDate(new Date());
        setUpdatedDate(new Date());
    }

    @PreUpdate
    private void preUpdate(){
        setUpdatedDate(new Date());
    }
}
