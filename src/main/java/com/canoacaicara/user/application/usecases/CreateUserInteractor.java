package com.canoacaicara.user.application.usecases;

import com.canoacaicara.user.infrastructure.gateways.UserGateway;
import com.canoacaicara.user.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUserInteractor {
    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;

    public CreateUserInteractor(UserGateway userGateway, PasswordEncoder passwordEncoder) {
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.password());
        User userWithHashedPassword = user.userWithHashedPassowrd(hashedPassword);
        return userGateway.createUser(userWithHashedPassword);
    }
}
