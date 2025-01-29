package com.canoacaicara.user.infrastructure.controllers;

import com.canoacaicara.user.application.usecases.CreateUserInteractor;
import com.canoacaicara.user.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final CreateUserInteractor createUserInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserInteractor createUserInteractor, UserDTOMapper userDTOMapper) {
        this.createUserInteractor = createUserInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        User userDomain = userDTOMapper.toUser(request);
        User userCreated = createUserInteractor.createUser(userDomain);
        return userDTOMapper.toResponse(userCreated);
    }


}
