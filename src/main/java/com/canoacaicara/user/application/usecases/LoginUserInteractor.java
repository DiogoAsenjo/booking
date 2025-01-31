package com.canoacaicara.user.application.usecases;

import com.canoacaicara.user.domain.User;
import com.canoacaicara.user.infrastructure.gateways.UserGateway;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class LoginUserInteractor {
    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;


    public LoginUserInteractor(UserGateway userGateway, PasswordEncoder passwordEncoder) {
        this.userGateway = userGateway;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(String email, String password) {
        Optional<User> userTryingToLogIn = userGateway.getUser(email);

        if (userTryingToLogIn.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User userFound = userTryingToLogIn.get();

        if (!passwordEncoder.matches(password, userFound.password())) {
            throw new RuntimeException("Invalid Password");
        }

        return "Logou";
    }
}
