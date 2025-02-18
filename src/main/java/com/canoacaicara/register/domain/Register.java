package com.canoacaicara.register.domain;

import com.canoacaicara.common.enums.ActivityType;

import java.util.Date;

public record Register(
        int userId,
        ActivityType activityType,
        Date date,
        int quantity
) {
}
