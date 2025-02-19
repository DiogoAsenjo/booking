package com.canoacaicara.register.infrastructure.controllers;

import com.canoacaicara.common.enums.ActivityType;

import java.time.LocalDate;

public record AllRegistersResponse(
        LocalDate date,
        int quantity,
        ActivityType activityType,
        String responsible
) {
}
