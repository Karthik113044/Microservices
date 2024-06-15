package com.microservice.post.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private String title;
    private String description;
    private String content;
}
