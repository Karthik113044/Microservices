package com.microservice.comment.comment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collation = "comment")
public class Comment {

    @Id
    private String commentId;
    private String name;
    private String email;
    private String body;
    private String postId;
}
