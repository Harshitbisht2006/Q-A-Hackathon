package com.lakshay.blog_practice.service.impl;

import com.lakshay.blog_practice.domain.entities.Post;
import com.lakshay.blog_practice.domain.entities.User;
import com.lakshay.blog_practice.repositories.PostRepository;
import com.lakshay.blog_practice.service.LikeService;
import com.lakshay.blog_practice.service.PostService;
import com.lakshay.blog_practice.service.UserService;
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

        post.getLikedByUsers().add(user);
        user.getLikedPosts().add(post);
        // We can also save userRepository.save(user)
        // User have CascadeType All bcz of One to Many relation saving this will save a user
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
}
