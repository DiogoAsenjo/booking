package com.canoacaicara.user.main;

import com.canoacaicara.user.application.usecases.LoginUserInteractor;
import com.canoacaicara.user.infrastructure.gateways.UserGateway;
import com.canoacaicara.user.application.usecases.CreateUserInteractor;
import com.canoacaicara.user.application.usecases.GetUserInteractor;
import com.canoacaicara.user.application.usecases.GetUsersInteractor;
import com.canoacaicara.user.infrastructure.controllers.UserDTOMapper;
import com.canoacaicara.user.infrastructure.gateways.UserEntityMapper;
import com.canoacaicara.user.infrastructure.gateways.UserRepositoryGateway;
import com.canoacaicara.user.infrastructure.persistance.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {
    @Bean
    CreateUserInteractor createUserCase(UserGateway userGateway, PasswordEncoder passwordEncoder) {
        return new CreateUserInteractor(userGateway, passwordEncoder);
    }

    @Bean
    LoginUserInteractor loginUserInteractor(UserGateway userGateway, PasswordEncoder passwordEncoder) {
        return new LoginUserInteractor(userGateway, passwordEncoder);
    }

    @Bean
    GetUsersInteractor getUsersInteractor(UserGateway userGateway) {
        return new GetUsersInteractor(userGateway);
    }

    @Bean
    GetUserInteractor getUserInteractor(UserGateway userGateway) {
        return new GetUserInteractor(userGateway);
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
