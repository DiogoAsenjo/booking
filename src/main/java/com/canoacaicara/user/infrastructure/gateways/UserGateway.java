package com.canoacaicara.user.infrastructure.gateways;

import com.canoacaicara.user.domain.User;

import java.util.List;

public interface UserGateway {
    User createUser(User user);
    List<User> getUsers();
    User getUser(String email);
}
