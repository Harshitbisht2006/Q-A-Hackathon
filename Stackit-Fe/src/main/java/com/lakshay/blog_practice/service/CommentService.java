package com.lakshay.blog_practice.service;

import com.lakshay.blog_practice.domain.dto.CreateCommentRequest;
import com.lakshay.blog_practice.domain.dto.UpdateCommentRequest;
import com.lakshay.blog_practice.domain.entities.Comment;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    Comment createComment(UUID userId, CreateCommentRequest request);
    void deleteComment(UUID commentId);
    List<Comment> getAllCommentByPostId(UUID postId);
    Comment getCommentById(UUID commentId);
    List<Comment> getAllCommentByUserId(UUID userId);
    Comment updateComment(UUID id, UpdateCommentRequest updateCommentRequest);
}
