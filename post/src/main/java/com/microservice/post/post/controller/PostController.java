package com.microservice.post.post.controller;

import com.microservice.post.post.entity.Post;
import com.microservice.post.post.payload.PostDto;
import com.microservice.post.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post) {

        Post post1 = postService.savePost(post);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }
    @GetMapping("/{postId}")
    public Optional<Post> getPostById(@PathVariable String postId) {

        return postService.getPostById(postId);
    }
    @GetMapping("/{postId}/comments")
    public ResponseEntity<PostDto> getPostWithComment(@PathVariable String postId){
        PostDto postWithComment = postService.getPostWithComment(postId);
        return new ResponseEntity<>(postWithComment, HttpStatus.OK);
    }
}
