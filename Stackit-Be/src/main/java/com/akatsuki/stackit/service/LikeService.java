package com.akatsuki.stackit.service;

import java.util.UUID;

public interface LikeService {
    void likePost(UUID userId, UUID postId);
    void dislikePost(UUID userId, UUID postId);
    int getLikeCount(UUID postId);
    int getDislikeCount(UUID postId);
    void unlikePost(UUID userId, UUID postId);
    boolean hasUserLiked(UUID userId, UUID postId);
}
