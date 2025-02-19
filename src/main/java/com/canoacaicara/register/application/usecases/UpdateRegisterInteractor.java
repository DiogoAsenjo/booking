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
        //TODO Criar a validacao se é de fato do usuário que chamou e se não não possui um registro aquele dia para aquele tipo.

        return registerDTOMapper.toResponse(registerFound);
    }
}
