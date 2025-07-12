package com.akatsuki.stackit.mappers;

import com.akatsuki.stackit.domain.dto.RegisterRequest;
import com.akatsuki.stackit.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toEntity(RegisterRequest registerRequest);
}
