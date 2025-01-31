package com.canoacaicara.user.domain;

public record User(
        String name,
        String email,
        String password,
        String whatsapp,
        String pix,
        String role
) {
    public User userWithHashedPassowrd(String hashedPassword) {
        return new User(name, email, hashedPassword,whatsapp, pix, role);
    }
}
