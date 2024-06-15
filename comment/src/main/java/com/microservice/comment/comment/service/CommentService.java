package com.microservice.comment.comment.service;

import com.microservice.comment.comment.config.RestTemplateConfig;
import com.microservice.comment.comment.entity.Comment;
import com.microservice.comment.comment.payload.Post;
import com.microservice.comment.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RestTemplateConfig restTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Comment saveComment(Comment comment) {

        Post post = restTemplate.getRestTemplate().getForObject("http://POST-SERVICE/api/posts/"+comment.getPostId(),Post.class);

        if (post != null) {
            String CommentId = UUID.randomUUID().toString();
            comment.setCommentId(CommentId);
            Comment savedComment = commentRepository.save(comment);
            return savedComment;
        }
        else{
            return null;
        }
    }

    public List<Comment> getAllComments(String postId) {
        Query query = new Query(Criteria.where("postId").is(postId));
        // Use a valid locale, e.g., "en"
        Collation collation = Collation.of("en").strength(Collation.ComparisonLevel.identical());
        return mongoTemplate.find(query.collation(collation), Comment.class);
    }

}
