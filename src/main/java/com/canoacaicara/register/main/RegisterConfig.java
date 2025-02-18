package com.canoacaicara.register.main;

import com.canoacaicara.register.application.mapper.RegisterDTOMapper;
import com.canoacaicara.register.application.usecases.CreateRegisterInteractor;
import com.canoacaicara.register.application.usecases.GetRegisterInteractor;
import com.canoacaicara.register.infrastructure.gateways.RegisterEntityMapper;
import com.canoacaicara.register.infrastructure.gateways.RegisterGateway;
import com.canoacaicara.register.infrastructure.gateways.RegisterRepositoryGateway;
import com.canoacaicara.register.infrastructure.persistance.RegisterRepository;
import com.canoacaicara.security.jwt.JWTService;
import com.canoacaicara.user.infrastructure.persistance.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterConfig {
    @Bean
    CreateRegisterInteractor createRegisterInteractor(RegisterGateway registerGateway, RegisterDTOMapper registerDTOMapper, JWTService jwtService) {
        return new CreateRegisterInteractor(registerGateway, registerDTOMapper, jwtService);
    }

    @Bean
    GetRegisterInteractor getRegisterInteractor(RegisterGateway registerGateway, RegisterDTOMapper registerDTOMapper, JWTService jwtService) {
        return new GetRegisterInteractor(registerGateway, registerDTOMapper, jwtService);
    }

    @Bean
    RegisterGateway registerGateway(RegisterRepository registerRepository, RegisterEntityMapper registerEntityMapper) {
        return new RegisterRepositoryGateway(registerRepository, registerEntityMapper);
    }

    @Bean
    RegisterEntityMapper registerEntityMapper(UserRepository userRepository) {
        return new RegisterEntityMapper(userRepository);
    }

    @Bean
    RegisterDTOMapper registerDTOMapper() {
        return new RegisterDTOMapper();
    }
}
