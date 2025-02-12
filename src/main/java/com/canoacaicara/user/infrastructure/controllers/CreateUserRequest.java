package com.canoacaicara.user.infrastructure.controllers;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank(message = "Name is mandatory")
        String name,
        @NotBlank(message = "Email is mandatory")
        String email,
        @NotBlank(message = "Password is mandatory")
        String password,
        @NotBlank(message = "Whatsapp is mandatory")
        String whatsapp,
        @NotBlank(message = "Pix is mandatory")
        String pix,
        @NotBlank(message = "role is mandatory")
        String role
) {
}
