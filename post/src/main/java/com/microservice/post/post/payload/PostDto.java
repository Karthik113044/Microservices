package com.microservice.post.post.payload;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String postId;
    private String title;
    private String description;
    private String content;
    private List<Comment> comments;
}
