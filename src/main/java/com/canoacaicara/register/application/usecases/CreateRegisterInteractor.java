package com.canoacaicara.register.application.usecases;

import com.canoacaicara.register.application.mapper.RegisterDTOMapper;
import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.controllers.CreateRegisterRequest;
import com.canoacaicara.register.infrastructure.controllers.RegisterResponse;
import com.canoacaicara.register.infrastructure.gateways.RegisterGateway;
import org.springframework.http.ResponseEntity;

public class CreateRegisterInteractor {
    private final RegisterGateway registerGateway;
    private final RegisterDTOMapper registerDTOMapper;

    public CreateRegisterInteractor(RegisterGateway registerGateway, RegisterDTOMapper registerDTOMapper) {
        this.registerGateway = registerGateway;
        this.registerDTOMapper = registerDTOMapper;
    }

    public RegisterResponse createRegister(CreateRegisterRequest request, String token) throws Exception {
        //Criar a lógica para extrair o userId do token.
        int idGambiarra = 1;
        Register registerDomain = registerDTOMapper.toRegister(request, idGambiarra);

        try {
            Register registerCreated = registerGateway.createRegister(registerDomain);
            return registerDTOMapper.toResponse(registerCreated);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
