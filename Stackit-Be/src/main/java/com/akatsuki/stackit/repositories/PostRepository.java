package com.akatsuki.stackit.repositories;

import com.akatsuki.stackit.domain.PostStatus;
import com.akatsuki.stackit.domain.entities.Category;
import com.akatsuki.stackit.domain.entities.Post;
import com.akatsuki.stackit.domain.entities.Tag;
import com.akatsuki.stackit.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus postStatus, Category category,Tag tags);
    List<Post> findAllByStatusAndCategory(PostStatus postStatus, Category category);
    List<Post> findAllByStatusAndTagsContaining(PostStatus postStatus, Tag tags);
    List<Post> findAllByStatus(PostStatus postStatus);
    List<Post> findAllByAuthorAndStatusAndCategoryAndTagsContaining(User loggedInUser, PostStatus postStatus, Category category,Tag tags);
    List<Post> findAllByAuthorAndStatusAndCategory(User loggedInUser, PostStatus postStatus, Category category);
    List<Post> findAllByAuthorAndStatusAndTagsContaining(User loggedInUser, PostStatus postStatus, Tag tags);
    List<Post> findAllByAuthorAndStatus(User loggedInUser, PostStatus postStatus);
}
