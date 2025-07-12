package com.akatsuki.stackit.mappers;

import com.akatsuki.stackit.domain.dto.CommentDto;
import com.akatsuki.stackit.domain.entities.Comment;
import com.akatsuki.stackit.domain.entities.Post;
import com.akatsuki.stackit.domain.entities.User;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-12T12:24:12+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Red Hat, Inc.)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDto toDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto.CommentDtoBuilder commentDto = CommentDto.builder();

        commentDto.userName( commentUserName( comment ) );
        commentDto.postId( commentPostId( comment ) );
        commentDto.id( comment.getId() );
        commentDto.content( comment.getContent() );
        commentDto.createdAt( comment.getCreatedAt() );

        return commentDto.build();
    }

    private String commentUserName(Comment comment) {
        User user = comment.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getName();
    }

    private UUID commentPostId(Comment comment) {
        Post post = comment.getPost();
        if ( post == null ) {
            return null;
        }
        return post.getId();
    }
}
