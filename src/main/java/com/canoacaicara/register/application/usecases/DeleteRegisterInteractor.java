package com.canoacaicara.register.application.usecases;

import com.canoacaicara.register.application.exceptions.RegisterManipulationException;
import com.canoacaicara.register.application.mapper.RegisterDTOMapper;
import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.gateways.RegisterGateway;
import com.canoacaicara.security.jwt.JWTService;

public class DeleteRegisterInteractor {
    private final RegisterGateway registerGateway;
    private final RegisterDTOMapper registerDTOMapper;
    private final JWTService jwtService;

    public DeleteRegisterInteractor(RegisterGateway registerGateway, RegisterDTOMapper registerDTOMapper, JWTService jwtService) {
        this.registerGateway = registerGateway;
        this.registerDTOMapper = registerDTOMapper;
        this.jwtService = jwtService;
    }

    public void deleteRegister(int registerId, String token) throws Exception {
        String clearToken = jwtService.clearToken(token);
        int userId = jwtService.getUserIdFromToken(clearToken);

        Register registerFound = registerGateway.getRegisterById(registerId);

        if (registerFound.userId() != userId) {
            throw new RegisterManipulationException("You're not responsible for this register!");
        }

        try {
            registerGateway.deleteRegister(registerId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
