package com.toufu.factory.media.blog.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private Boolean published;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @NotNull
    @JsonManagedReference
    private Category category;

    @ManyToMany( fetch = FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Tag> tags;

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
