package com.akatsuki.stackit.mappers;

import com.akatsuki.stackit.domain.CreatePostRequest;
import com.akatsuki.stackit.domain.UpdatePostRequest;
import com.akatsuki.stackit.domain.dto.AuthorDto;
import com.akatsuki.stackit.domain.dto.CommentDto;
import com.akatsuki.stackit.domain.dto.CreatePostRequestDto;
import com.akatsuki.stackit.domain.dto.PostDto;
import com.akatsuki.stackit.domain.dto.TagDto;
import com.akatsuki.stackit.domain.dto.UpdatePostRequestDto;
import com.akatsuki.stackit.domain.entities.Comment;
import com.akatsuki.stackit.domain.entities.Post;
import com.akatsuki.stackit.domain.entities.Tag;
import com.akatsuki.stackit.domain.entities.User;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-12T12:24:12+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Red Hat, Inc.)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public PostDto toDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDto.PostDtoBuilder postDto = PostDto.builder();

        postDto.author( userToAuthorDto( post.getAuthor() ) );
        postDto.category( categoryMapper.toDto( post.getCategory() ) );
        postDto.tags( tagSetToTagDtoSet( post.getTags() ) );
        postDto.postStatus( post.getStatus() );
        if ( post.getLikedByUsers() != null ) {
            postDto.likeCount( (int) calculatePostCount( post.getLikedByUsers() ) );
        }
        postDto.comments( commentListToCommentDtoList( post.getComments() ) );
        postDto.id( post.getId() );
        postDto.title( post.getTitle() );
        postDto.content( post.getContent() );
        postDto.readingTime( post.getReadingTime() );
        postDto.createdAt( post.getCreatedAt() );
        postDto.updatedAt( post.getUpdatedAt() );

        return postDto.build();
    }

    @Override
    public CreatePostRequest toCreatePostRequest(CreatePostRequestDto createPostRequestDto) {
        if ( createPostRequestDto == null ) {
            return null;
        }

        CreatePostRequest.CreatePostRequestBuilder createPostRequest = CreatePostRequest.builder();

        createPostRequest.title( createPostRequestDto.getTitle() );
        createPostRequest.content( createPostRequestDto.getContent() );
        createPostRequest.categoryId( createPostRequestDto.getCategoryId() );
        Set<UUID> set = createPostRequestDto.getTagIds();
        if ( set != null ) {
            createPostRequest.tagIds( new LinkedHashSet<UUID>( set ) );
        }
        createPostRequest.status( createPostRequestDto.getStatus() );

        return createPostRequest.build();
    }

    @Override
    public UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto updatePostRequestDto) {
        if ( updatePostRequestDto == null ) {
            return null;
        }

        UpdatePostRequest.UpdatePostRequestBuilder updatePostRequest = UpdatePostRequest.builder();

        updatePostRequest.id( updatePostRequestDto.getId() );
        updatePostRequest.title( updatePostRequestDto.getTitle() );
        updatePostRequest.content( updatePostRequestDto.getContent() );
        updatePostRequest.categoryId( updatePostRequestDto.getCategoryId() );
        Set<UUID> set = updatePostRequestDto.getTagIds();
        if ( set != null ) {
            updatePostRequest.tagIds( new LinkedHashSet<UUID>( set ) );
        }
        updatePostRequest.status( updatePostRequestDto.getStatus() );

        return updatePostRequest.build();
    }

    protected AuthorDto userToAuthorDto(User user) {
        if ( user == null ) {
            return null;
        }

        AuthorDto.AuthorDtoBuilder authorDto = AuthorDto.builder();

        authorDto.id( user.getId() );
        authorDto.name( user.getName() );

        return authorDto.build();
    }

    protected Set<TagDto> tagSetToTagDtoSet(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        Set<TagDto> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( Tag tag : set ) {
            set1.add( tagMapper.toDto( tag ) );
        }

        return set1;
    }

    protected List<CommentDto> commentListToCommentDtoList(List<Comment> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentDto> list1 = new ArrayList<CommentDto>( list.size() );
        for ( Comment comment : list ) {
            list1.add( commentMapper.toDto( comment ) );
        }

        return list1;
    }
}
