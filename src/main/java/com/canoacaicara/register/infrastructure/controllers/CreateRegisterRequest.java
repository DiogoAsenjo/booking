package com.canoacaicara.register.infrastructure.controllers;

import com.canoacaicara.common.enums.ActivityType;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CreateRegisterRequest(
        @NotNull(message = "Date is mandatoy")
        Date date,

        @NotNull(message = "Quantity is mandatory")
        int quantity,

        @NotNull(message = "Activity type is mandatory")
        ActivityType activityType
) {
}
