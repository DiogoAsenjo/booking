package com.canoacaicara.register.application.usecases;

import com.canoacaicara.register.application.exceptions.RegisterCreationException;
import com.canoacaicara.register.application.mapper.RegisterDTOMapper;
import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.controllers.CreateRegisterRequest;
import com.canoacaicara.register.infrastructure.controllers.RegisterResponse;
import com.canoacaicara.register.infrastructure.gateways.RegisterGateway;
import com.canoacaicara.security.jwt.JWTService;

import java.util.List;

public class CreateRegisterInteractor {
    private final RegisterGateway registerGateway;
    private final RegisterDTOMapper registerDTOMapper;
    private final JWTService jwtService;

    public CreateRegisterInteractor(RegisterGateway registerGateway, RegisterDTOMapper registerDTOMapper, JWTService jwtService) {
        this.registerGateway = registerGateway;
        this.registerDTOMapper = registerDTOMapper;
        this.jwtService = jwtService;
    }

    public RegisterResponse createRegister(CreateRegisterRequest request, String token) throws Exception {
        String clearToken = jwtService.clearToken(token);
        int userId = jwtService.getUserIdFromToken(clearToken);
        Register registerDomain = registerDTOMapper.toRegister(request, userId);

        List<Register> registerWithTheSameDateAndType = registerGateway.getUserRegisterByDateAndType(userId, request.date(), request.activityType());

        if (!registerWithTheSameDateAndType.isEmpty()) {
            throw new RegisterCreationException("You already have a register of this type in this date!");
        }

        try {
            Register registerCreated = registerGateway.createRegister(registerDomain);
            return registerDTOMapper.toResponse(registerCreated);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
