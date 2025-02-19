package com.canoacaicara.register.infrastructure.gateways;

import com.canoacaicara.common.enums.ActivityType;
import com.canoacaicara.register.application.mapper.RegisterDTOMapper;
import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.controllers.AllRegistersResponse;
import com.canoacaicara.register.infrastructure.persistance.RegisterEntity;
import com.canoacaicara.register.infrastructure.persistance.RegisterRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class RegisterRepositoryGateway implements RegisterGateway{
    private final RegisterRepository registerRepository;
    private final RegisterEntityMapper registerEntityMapper;
    private final RegisterDTOMapper registerDTOMapper;

    public RegisterRepositoryGateway(RegisterRepository registerRepository, RegisterEntityMapper registerEntityMapper, RegisterDTOMapper registerDTOMapper) {
        this.registerRepository = registerRepository;
        this.registerEntityMapper = registerEntityMapper;
        this.registerDTOMapper = registerDTOMapper;
    }

    @Override
    public Register createRegister(Register register) {
        RegisterEntity registerEntity = registerEntityMapper.toEntity(register);
        RegisterEntity registerEntitySaved = registerRepository.save(registerEntity);
        return registerEntityMapper.toDomain(registerEntitySaved);
    }

    @Override
    public List<Register> getUserRegisters(int userId) {
        List<RegisterEntity> registers = registerRepository.findByUserId(userId);
        return registers.stream().map(registerEntityMapper::toDomain).toList();
    }

    @Override
    public List<AllRegistersResponse> getAllRegisters() {
        List<RegisterEntity> registers = registerRepository.findAll();
        return registers.stream().map(registerDTOMapper::toAllRegistersResponse).toList();
    }

    @Override
    public List<Register> getUserRegisterByDateAndType(int userId, LocalDate date, ActivityType activityType) {
        List<RegisterEntity> register = registerRepository.findByUserIdAndDateAndActivityType(userId, date, activityType);
        return register.stream().map(registerEntityMapper::toDomain).toList();
    }
}
