package com.canoacaicara.register.infrastructure.controllers;

import com.canoacaicara.common.enums.ActivityType;

import java.util.Date;

public record RegisterResponse(
        Date date,
        int quantity,
        ActivityType activityType
) {
}
