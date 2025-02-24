package com.canoacaicara.register.application.usecases;

import com.canoacaicara.register.application.exceptions.RegisterCreationException;
import com.canoacaicara.register.application.mapper.RegisterDTOMapper;
import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.controllers.CreateRegisterRequest;
import com.canoacaicara.register.infrastructure.controllers.RegisterResponse;
import com.canoacaicara.register.infrastructure.gateways.RegisterGateway;
import com.canoacaicara.security.jwt.JWTService;

import java.util.List;

public class UpdateRegisterInteractor {
    private final RegisterGateway registerGateway;
    private final RegisterDTOMapper registerDTOMapper;
    private final JWTService jwtService;

    public UpdateRegisterInteractor(RegisterGateway registerGateway, RegisterDTOMapper registerDTOMapper, JWTService jwtService) {
        this.registerGateway = registerGateway;
        this.registerDTOMapper = registerDTOMapper;
        this.jwtService = jwtService;
    }

    public RegisterResponse updateRegister(int registerId, CreateRegisterRequest request, String token) throws Exception {
        String clearToken = jwtService.clearToken(token);
        int userId = jwtService.getUserIdFromToken(clearToken);

        Register registerFound = registerGateway.getRegisterById(registerId);

        if (registerFound.userId() != userId) {
            throw new RegisterCreationException("You're not responsible for this register!");
        }

        List<Register> registerWithTheSameDateAndType = registerGateway.getUserRegisterByDateAndTypeExcludingId(userId, request.date(), request.activityType(), registerId);

        if (!registerWithTheSameDateAndType.isEmpty()) {
            throw new RegisterCreationException("You already have a register of this type in this date!");
        }

        Register registerToBeUpdated = registerDTOMapper.toRegisterWithId(request, userId, registerId);

        try {
            Register registerUpdated = registerGateway.updateRegister(registerToBeUpdated);
            return registerDTOMapper.toResponse(registerUpdated);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
