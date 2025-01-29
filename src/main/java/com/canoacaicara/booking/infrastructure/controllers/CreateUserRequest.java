package com.canoacaicara.booking.infrastructure.controllers;

public record CreateUserRequest(
        String name,
        String email,
        String password,
        String whatsapp,
        String pix,
        String role
) {
}
