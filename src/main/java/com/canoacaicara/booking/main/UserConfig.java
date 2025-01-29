package com.canoacaicara.booking.main;

import com.canoacaicara.booking.application.gateways.UserGateway;
import com.canoacaicara.booking.application.usecases.CreateUserInteractor;
import com.canoacaicara.booking.infrastructure.controllers.UserDTOMapper;
import com.canoacaicara.booking.infrastructure.gateways.UserEntityMapper;
import com.canoacaicara.booking.infrastructure.gateways.UserRepositoryGateway;
import com.canoacaicara.booking.infrastructure.persistance.UserRepository;
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
