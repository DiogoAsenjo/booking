package com.canoacaicara.booking.infrastructure.gateways;

import com.canoacaicara.booking.application.gateways.UserGateway;
import com.canoacaicara.booking.domain.entity.User;
import com.canoacaicara.booking.infrastructure.persistance.UserEntity;
import com.canoacaicara.booking.infrastructure.persistance.UserRepository;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User userDomain) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomain);
        UserEntity userSaved = userRepository.save(userEntity);
        return userEntityMapper.toDomain(userSaved);
    }
}
