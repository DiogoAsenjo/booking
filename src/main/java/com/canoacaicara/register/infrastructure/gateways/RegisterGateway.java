package com.canoacaicara.register.infrastructure.gateways;

import com.canoacaicara.common.enums.ActivityType;
import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.controllers.AllRegistersResponse;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RegisterGateway {
    Register createRegister(Register register);
    List<Register> getUserRegisters(int userId);
    List<AllRegistersResponse> getAllRegisters();
    List<Register> getUserRegisterByDateAndType(int userID, LocalDate date, ActivityType activityType);
}
