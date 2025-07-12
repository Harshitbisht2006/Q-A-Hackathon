package com.akatsuki.stackit.service;

import com.akatsuki.stackit.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID userId);
}
