package com.canoacaicara.booking.application.gateways;

import com.canoacaicara.booking.domain.entity.User;

public interface UserGateway {
    User createUser(User user);
}
