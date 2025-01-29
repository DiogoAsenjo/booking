package com.canoacaicara.booking.infrastructure.controllers;

import com.canoacaicara.booking.domain.entity.User;

public class UserDTOMapper {
    CreateUserResponse toResponse(User user) {
        return new CreateUserResponse(user.name(), user.email(), user.role());
    }

    public User toUser(CreateUserRequest request) {
        return new User(request.name(), request.email(), request.password(), request.whatsapp(), request.pix(), request.role());
    }
}
