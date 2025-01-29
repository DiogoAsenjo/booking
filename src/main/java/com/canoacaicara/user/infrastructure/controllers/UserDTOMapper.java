package com.canoacaicara.user.infrastructure.controllers;

import com.canoacaicara.user.domain.User;

public class UserDTOMapper {
    UserResponse toResponse(User user) {
        return new UserResponse(user.name(), user.email(), user.role());
    }

    public User toUser(CreateUserRequest request) {
        return new User(request.name(), request.email(), request.password(), request.whatsapp(), request.pix(), request.role());
    }
}
