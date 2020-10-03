package com.toufu.factory.media.blog.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String name;
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
