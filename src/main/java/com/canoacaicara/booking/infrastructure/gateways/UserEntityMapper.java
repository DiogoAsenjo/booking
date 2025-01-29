package com.canoacaicara.booking.infrastructure.gateways;

import com.canoacaicara.booking.domain.entity.User;
import com.canoacaicara.booking.infrastructure.persistance.UserEntity;

public class UserEntityMapper {
    UserEntity toEntity(User userDomain) {
        return new UserEntity(userDomain.name(), userDomain.email(), userDomain.password(), userDomain.whatsapp(), userDomain.pix(), userDomain.role());
    }

    User toDomain(UserEntity userEntity) {
        return new User(userEntity.getName(), userEntity.getEmail(), userEntity.getPassword(), userEntity.getWhatsapp(), userEntity.getPix(), userEntity.getRole());
    }
}
