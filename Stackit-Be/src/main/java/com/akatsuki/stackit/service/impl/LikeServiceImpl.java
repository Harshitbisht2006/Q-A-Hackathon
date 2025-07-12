package com.akatsuki.stackit.service.impl;

import com.akatsuki.stackit.domain.entities.Post;
import com.akatsuki.stackit.domain.entities.User;
import com.akatsuki.stackit.repositories.PostRepository;
import com.akatsuki.stackit.service.LikeService;
import com.akatsuki.stackit.service.PostService;
import com.akatsuki.stackit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final UserService userService;
    private final PostService postService;
    private final PostRepository postRepository;

    @Transactional
    @Override
    public void likePost(UUID userId, UUID postId) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);

        if(post.getLikedByUsers().contains(user)) {
            return;
        }

        if(post.getDislikedByUsers().contains(user)) {
            post.getDislikedByUsers().remove(user);
            user.getDislikedPosts().remove(post);
        }

        post.getLikedByUsers().add(user);
        user.getLikedPosts().add(post);
        // We can also save userRepository.save(user)
        // User have CascadeType All bcz of One to Many relation saving this will save a user
        postRepository.save(post);
    }

    @Override
    public void dislikePost(UUID userId, UUID postId) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);

        if(post.getDislikedByUsers().contains(user)) {
            return;
        }

        if(post.getLikedByUsers().contains(user)) {
            post.getLikedByUsers().remove(user);
            user.getLikedPosts().remove(post);
        }

        post.getDislikedByUsers().add(user);
        user.getDislikedPosts().add(post);

        postRepository.save(post);
    }

    @Transactional
    @Override
    public void unlikePost(UUID userId, UUID postId) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);

        if(!post.getLikedByUsers().contains(user)) {
            return;
        }

        post.getLikedByUsers().remove(user);
        user.getLikedPosts().remove(post);
        postRepository.save(post);
    }

    @Transactional
    @Override
    public boolean hasUserLiked(UUID userId, UUID postId) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);

        return post.getLikedByUsers().contains(user);
    }

    @Transactional
    @Override
    public int getLikeCount(UUID postId) {
        Post post = postService.getPostById(postId);
        return post.getLikedByUsers().size();
    }

    @Transactional
    @Override
    public int getDislikeCount(UUID postId) {
        Post post = postService.getPostById(postId);
        return post.getDislikedByUsers().size();
    }
}
