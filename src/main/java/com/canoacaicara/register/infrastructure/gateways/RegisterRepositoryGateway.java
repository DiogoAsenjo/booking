package com.canoacaicara.register.infrastructure.gateways;

import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.persistance.RegisterEntity;
import com.canoacaicara.register.infrastructure.persistance.RegisterRepository;

public class RegisterRepositoryGateway implements RegisterGateway{
    private final RegisterRepository registerRepository;
    private final RegisterEntityMapper registerEntityMapper;

    public RegisterRepositoryGateway(RegisterRepository registerRepository, RegisterEntityMapper registerEntityMapper) {
        this.registerRepository = registerRepository;
        this.registerEntityMapper = registerEntityMapper;
    }

    @Override
    public Register createRegister(Register register) {
        RegisterEntity registerEntity = registerEntityMapper.toEntity(register);
        RegisterEntity registerEntitySaved = registerRepository.save(registerEntity);
        return registerEntityMapper.toDomain(registerEntitySaved);
    }
}
