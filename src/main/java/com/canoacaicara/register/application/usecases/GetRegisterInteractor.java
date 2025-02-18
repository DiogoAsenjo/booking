package com.canoacaicara.register.application.usecases;

import com.canoacaicara.register.application.exceptions.RegisterNotFoundException;
import com.canoacaicara.register.application.mapper.RegisterDTOMapper;
import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.controllers.AllRegistersResponse;
import com.canoacaicara.register.infrastructure.controllers.RegisterResponse;
import com.canoacaicara.register.infrastructure.gateways.RegisterGateway;
import com.canoacaicara.register.infrastructure.persistance.RegisterEntity;
import com.canoacaicara.security.jwt.JWTService;

import java.util.List;

public class GetRegisterInteractor {
    private final RegisterGateway registerGateway;
    private final RegisterDTOMapper registerDTOMapper;
    private final JWTService jwtService;

    public GetRegisterInteractor(RegisterGateway registerGateway, RegisterDTOMapper registerDTOMapper, JWTService jwtService) {
        this.registerGateway = registerGateway;
        this.registerDTOMapper = registerDTOMapper;
        this.jwtService = jwtService;
    }

    public List<RegisterResponse> getUserRegisters(String token) {
        String clearToken = jwtService.clearToken(token);
        int userId = jwtService.getUserIdFromToken(clearToken);

        List<Register> registersFound = registerGateway.getUserRegisters(userId);

        if (registersFound.isEmpty()) {
            throw new RegisterNotFoundException("Registers not found");
        }

        return registersFound.stream().map(registerDTOMapper::toResponse).toList();
    }

    public List<AllRegistersResponse> getAllRegisters() {
        List<AllRegistersResponse> registersFound = registerGateway.getAllRegisters();

        if (registersFound.isEmpty()) {
            throw new RegisterNotFoundException("Registers not found");
        }

        return registersFound;
    }
}
