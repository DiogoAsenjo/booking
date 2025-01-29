package com.canoacaicara.user.application.usecases;

import com.canoacaicara.user.infrastructure.gateways.UserGateway;
import com.canoacaicara.user.domain.User;

import java.util.List;

public class GetUsersInteractor {
    private final UserGateway userGateway;

    public GetUsersInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<User> getUsers() {
        return userGateway.getUsers();
    }
}
