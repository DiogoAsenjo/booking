package com.canoacaicara.register.infrastructure.gateways;

import com.canoacaicara.register.domain.Register;
import com.canoacaicara.register.infrastructure.persistance.RegisterEntity;
import com.canoacaicara.user.application.exceptions.UserNotFoundException;
import com.canoacaicara.user.infrastructure.persistance.UserEntity;
import com.canoacaicara.user.infrastructure.persistance.UserRepository;

public class RegisterEntityMapper {
  private final UserRepository userRepository;

    public RegisterEntityMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    RegisterEntity toEntity(Register registerDomain) {
        UserEntity user = userRepository.findById(registerDomain.userId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        return new RegisterEntity(user, registerDomain.date(), registerDomain.quantity(), registerDomain.activityType());
    }

    Register toDomain(RegisterEntity registerEntity) {
        return new Register(registerEntity.getUser().getId(), registerEntity.getActivityType(), registerEntity.getDate(), registerEntity.getQuantity());
    }
}
