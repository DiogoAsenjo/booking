package com.canoacaicara.register.infrastructure.controllers;

import java.util.Date;

public record RegisterResponse(
        Date date,
        int quantity
) {
}
