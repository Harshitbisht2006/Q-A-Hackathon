package com.akatsuki.stackit.mappers;

import com.akatsuki.stackit.domain.dto.RegisterRequest;
import com.akatsuki.stackit.domain.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-12T12:24:12+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Red Hat, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(RegisterRequest registerRequest) {
        if ( registerRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( registerRequest.getEmail() );
        user.password( registerRequest.getPassword() );
        user.name( registerRequest.getName() );

        return user.build();
    }
}
