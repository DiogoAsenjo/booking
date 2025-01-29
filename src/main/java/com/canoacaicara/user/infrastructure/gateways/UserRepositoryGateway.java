package com.canoacaicara.user.infrastructure.gateways;

import com.canoacaicara.user.domain.User;
import com.canoacaicara.user.infrastructure.persistance.UserEntity;
import com.canoacaicara.user.infrastructure.persistance.UserRepository;

import java.util.List;

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

    @Override
    public List<User> getUsers() {
        List<UserEntity> usersEntitty = userRepository.findAll();
        return usersEntitty.stream().map(userEntityMapper::toDomain).toList();
    }

    @Override
    public User getUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userEntityMapper.toDomain(userEntity);
    }
}
