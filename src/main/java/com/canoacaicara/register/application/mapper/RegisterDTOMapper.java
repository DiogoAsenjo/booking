package com.canoacaicara.register.application.mapper;

import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.controllers.CreateRegisterRequest;
import com.canoacaicara.register.infrastructure.controllers.RegisterResponse;

public class RegisterDTOMapper {
    public RegisterResponse toResponse(Register register) {
        return new RegisterResponse(register.date(), register.quantity());
    }

    public Register toRegister(CreateRegisterRequest request, int userId) {
        return new Register(userId, request.activityType(),request.date(), request.quantity());
    }
}
