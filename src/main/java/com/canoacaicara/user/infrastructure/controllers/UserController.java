package com.canoacaicara.user.infrastructure.controllers;

import com.canoacaicara.user.application.usecases.CreateUserInteractor;
import com.canoacaicara.user.application.usecases.GetUserInteractor;
import com.canoacaicara.user.application.usecases.GetUsersInteractor;
import com.canoacaicara.user.application.usecases.LoginUserInteractor;
import com.canoacaicara.user.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final CreateUserInteractor createUserInteractor;
    private final GetUsersInteractor getUsersInteractor;
    private final GetUserInteractor getUserInteractor;
    private final UserDTOMapper userDTOMapper;
    private final LoginUserInteractor loginUserInteractor;

    public UserController(CreateUserInteractor createUserInteractor, GetUsersInteractor getUsersInteractor, GetUserInteractor getUserInteractor, UserDTOMapper userDTOMapper, LoginUserInteractor loginUserInteractor) {
        this.createUserInteractor = createUserInteractor;
        this.getUsersInteractor = getUsersInteractor;
        this.getUserInteractor = getUserInteractor;
        this.userDTOMapper = userDTOMapper;
        this.loginUserInteractor = loginUserInteractor;
    }

    @PostMapping
    UserResponse createUser(@RequestBody CreateUserRequest request) {
        User userDomain = userDTOMapper.toUser(request);
        User userCreated = createUserInteractor.createUser(userDomain);
        return userDTOMapper.toResponse(userCreated);
    }

    @PostMapping("/login")
    String login(@RequestBody LoginUserRequest loginUserRequest) {
        return loginUserInteractor.login(loginUserRequest.email(), loginUserRequest.password());
    }

    @GetMapping
    List<UserResponse> getUsers() {
        List<User> usersDomainFound = getUsersInteractor.getUsers();
        return usersDomainFound.stream().map(userDTOMapper::toResponse).toList();
    }

    @GetMapping("/")
    UserResponse getUser(@RequestParam String email) {
        User userDomainFound = getUserInteractor.getUser(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return userDTOMapper.toResponse(userDomainFound);
    }
}
