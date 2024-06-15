package com.microservice.post.post.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.microservice.post.post.entity.Post;

public interface PostRepository extends MongoRepository<Post, String> {
}
