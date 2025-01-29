package com.canoacaicara.user.application.gateways;

import com.canoacaicara.user.domain.User;

public interface UserGateway {
    User createUser(User user);
}
