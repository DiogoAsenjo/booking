package com.canoacaicara.user.infrastructure.controllers;

public record LoginUserRequest(
        String email,
        String password
) {
}
