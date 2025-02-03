package com.canoacaicara.user.application.usecases;

import com.canoacaicara.user.application.mapper.UserDTOMapper;
import com.canoacaicara.user.infrastructure.controllers.UserResponse;
import com.canoacaicara.user.infrastructure.gateways.UserGateway;
import com.canoacaicara.user.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class GetUserInteractor {
    private final UserGateway userGateway;
    private final UserDTOMapper userDTOMapper;

    public GetUserInteractor(UserGateway userGateway, UserDTOMapper userDTOMapper) {
        this.userGateway = userGateway;
        this.userDTOMapper = userDTOMapper;
    }

    public UserResponse getUser(String email) {
        User userDomainFound = userGateway.getUser(email).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return userDTOMapper.toResponse(userDomainFound);
    }
}
