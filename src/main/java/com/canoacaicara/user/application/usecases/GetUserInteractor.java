package com.canoacaicara.user.application.usecases;

import com.canoacaicara.user.infrastructure.gateways.UserGateway;
import com.canoacaicara.user.domain.User;

public class GetUserInteractor {
    private final UserGateway userGateway;

    public GetUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User getUser(String email) {
        return userGateway.getUser(email);
    }
}
