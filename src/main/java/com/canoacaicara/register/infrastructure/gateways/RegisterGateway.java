package com.canoacaicara.register.infrastructure.gateways;

import com.canoacaicara.register.domain.Register;

import java.util.List;

public interface RegisterGateway {
    Register createRegister(Register register);
    List<Register> getUserRegisters(int userId);
}
