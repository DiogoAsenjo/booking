package com.canoacaicara.register.infrastructure.gateways;

import com.canoacaicara.register.domain.Register;

public interface RegisterGateway {
    Register createRegister(Register register);
}
