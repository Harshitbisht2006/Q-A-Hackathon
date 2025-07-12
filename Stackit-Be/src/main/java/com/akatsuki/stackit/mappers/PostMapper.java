package com.akatsuki.stackit.mappers;

import com.akatsuki.stackit.domain.CreatePostRequest;
import com.akatsuki.stackit.domain.UpdatePostRequest;
import com.akatsuki.stackit.domain.dto.CreatePostRequestDto;
import com.akatsuki.stackit.domain.dto.PostDto;
import com.akatsuki.stackit.domain.dto.UpdatePostRequestDto;
import com.akatsuki.stackit.domain.entities.Post;
import com.akatsuki.stackit.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, CategoryMapper.class, TagMapper.class, CommentMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "postStatus", source = "status")
    @Mapping(target = "likeCount", source = "likedByUsers", qualifiedByName = "calculateLikeCount")
    @Mapping(target = "comments", source = "comments")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto createPostRequestDto);
    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto updatePostRequestDto);

    @Named("calculateLikeCount")
    default long calculatePostCount(Set<User> likedByUser) {
        if(null == likedByUser) return 0;
        return likedByUser.size();
    }
}
