package com.akatsuki.stackit.mappers;

import com.akatsuki.stackit.domain.dto.CommentDto;
import com.akatsuki.stackit.domain.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    @Mapping(target = "userName", source = "user.name")
    @Mapping(target = "postId", source = "post.id")
    CommentDto toDto(Comment comment);
}
