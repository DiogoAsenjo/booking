package com.canoacaicara.user.application.usecases;

import com.canoacaicara.user.application.gateways.UserGateway;
import com.canoacaicara.user.domain.User;

public class CreateUserInteractor {
    private UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        return userGateway.createUser(user);
    }
}
