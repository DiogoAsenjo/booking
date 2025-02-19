package com.canoacaicara.register.domain;

import com.canoacaicara.common.enums.ActivityType;

import java.time.LocalDate;

public record Register(
        int userId,
        ActivityType activityType,
        LocalDate date,
        int quantity
) {
}
