package com.canoacaicara.user.main;

import com.canoacaicara.user.application.gateways.UserGateway;
import com.canoacaicara.user.application.usecases.CreateUserInteractor;
import com.canoacaicara.user.infrastructure.controllers.UserDTOMapper;
import com.canoacaicara.user.infrastructure.gateways.UserEntityMapper;
import com.canoacaicara.user.infrastructure.gateways.UserRepositoryGateway;
import com.canoacaicara.user.infrastructure.persistance.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CreateUserInteractor createUserCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper UserDTOMapper() {
        return new UserDTOMapper();
    }
}
