package com.akatsuki.stackit.mappers;

import com.akatsuki.stackit.domain.dto.TagDto;
import com.akatsuki.stackit.domain.entities.Tag;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-12T12:24:12+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Red Hat, Inc.)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagDto toDto(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDto.TagDtoBuilder tagDto = TagDto.builder();

        if ( tag.getPosts() != null ) {
            tagDto.postCount( (int) calculatePostCount( tag.getPosts() ) );
        }
        tagDto.id( tag.getId() );
        tagDto.name( tag.getName() );

        return tagDto.build();
    }
}
