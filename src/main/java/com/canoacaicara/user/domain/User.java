package com.canoacaicara.user.domain;

public record User(
        String name,
        String email,
        String password,
        String whatsapp,
        String pix,
        String role
) {
}
