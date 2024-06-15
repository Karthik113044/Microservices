package com.microservice.comment.comment.repository;

import com.microservice.comment.comment.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepository extends MongoRepository<Comment,String> {

}
