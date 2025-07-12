package com.lakshay.blog_practice.service;

import java.util.UUID;

public interface LikeService {
    void likePost(UUID userId, UUID postId);
    int getLikeCount(UUID postId);
    void unlikePost(UUID userId, UUID postId);
    boolean hasUserLiked(UUID userId, UUID postId);
}
