package com.canoacaicara.booking.domain.entity;

public record User(
        String name,
        String email,
        String password,
        String whatsapp,
        String pix,
        String role
) {
}
