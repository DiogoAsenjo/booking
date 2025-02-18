package com.canoacaicara.register.infrastructure.controllers;

import com.canoacaicara.common.enums.ActivityType;

import java.util.Date;

public record AllRegistersResponse(
        Date date,
        int quantity,
        ActivityType activityType,
        String responsible
) {
}
