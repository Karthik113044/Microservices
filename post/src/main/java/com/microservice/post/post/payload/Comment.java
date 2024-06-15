package com.microservice.post.post.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private String commentId;
    private String name;
    private String email;
    private String body;
    private String postId;
}
