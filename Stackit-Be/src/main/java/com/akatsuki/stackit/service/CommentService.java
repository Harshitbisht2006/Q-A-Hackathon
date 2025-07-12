package com.akatsuki.stackit.service;

import com.akatsuki.stackit.domain.dto.CreateCommentRequest;
import com.akatsuki.stackit.domain.dto.UpdateCommentRequest;
import com.akatsuki.stackit.domain.entities.Comment;

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
