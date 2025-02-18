package com.canoacaicara.register.infrastructure.gateways;

import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.controllers.AllRegistersResponse;
import com.canoacaicara.register.infrastructure.persistance.RegisterEntity;

import java.util.List;

public interface RegisterGateway {
    Register createRegister(Register register);
    List<Register> getUserRegisters(int userId);
    List<AllRegistersResponse> getAllRegisters();
}
