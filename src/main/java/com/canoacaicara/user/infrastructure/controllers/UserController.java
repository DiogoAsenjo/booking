package com.canoacaicara.user.infrastructure.controllers;

import com.canoacaicara.user.application.usecases.CreateUserInteractor;
import com.canoacaicara.user.application.usecases.GetUserInteractor;
import com.canoacaicara.user.application.usecases.GetUsersInteractor;
import com.canoacaicara.user.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final CreateUserInteractor createUserInteractor;
    private final GetUsersInteractor getUsersInteractor;
    private final GetUserInteractor getUserInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserInteractor createUserInteractor, GetUsersInteractor getUsersInteractor, GetUserInteractor getUserInteractor, UserDTOMapper userDTOMapper) {
        this.createUserInteractor = createUserInteractor;
        this.getUsersInteractor = getUsersInteractor;
        this.getUserInteractor = getUserInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    UserResponse createUser(@RequestBody CreateUserRequest request) {
        User userDomain = userDTOMapper.toUser(request);
        User userCreated = createUserInteractor.createUser(userDomain);
        return userDTOMapper.toResponse(userCreated);
    }

    @GetMapping
    List<UserResponse> getUsers() {
        List<User> usersDomainFound = getUsersInteractor.getUsers();
        return usersDomainFound.stream().map(userDTOMapper::toResponse).toList();
    }

    @GetMapping("/")
    UserResponse getUser(@RequestParam String email) {
        User userDomainFound = getUserInteractor.getUser(email);
        return userDTOMapper.toResponse(userDomainFound);
    }
}
