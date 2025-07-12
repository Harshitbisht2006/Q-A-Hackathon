package com.lakshay.blog_practice.mappers;

import com.lakshay.blog_practice.domain.dto.CommentDto;
import com.lakshay.blog_practice.domain.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    @Mapping(target = "userName", source = "user.name")
    @Mapping(target = "postId", source = "post.id")
    CommentDto toDto(Comment comment);
}
