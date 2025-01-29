package com.canoacaicara.booking.application.usecases;

import com.canoacaicara.booking.application.gateways.UserGateway;
import com.canoacaicara.booking.domain.entity.User;

public class CreateUserInteractor {
    private UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        return userGateway.createUser(user);
    }
}
