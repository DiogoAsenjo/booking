package com.canoacaicara.user.infrastructure.controllers;

import com.canoacaicara.user.application.usecases.CreateUserInteractor;
import com.canoacaicara.user.application.usecases.GetUserInteractor;
import com.canoacaicara.user.application.usecases.GetUsersInteractor;
import com.canoacaicara.user.application.usecases.LoginUserInteractor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final CreateUserInteractor createUserInteractor;
    private final GetUsersInteractor getUsersInteractor;
    private final GetUserInteractor getUserInteractor;
    private final LoginUserInteractor loginUserInteractor;

    public UserController(CreateUserInteractor createUserInteractor, GetUsersInteractor getUsersInteractor, GetUserInteractor getUserInteractor, LoginUserInteractor loginUserInteractor) {
        this.createUserInteractor = createUserInteractor;
        this.getUsersInteractor = getUsersInteractor;
        this.getUserInteractor = getUserInteractor;
        this.loginUserInteractor = loginUserInteractor;
    }

    @PostMapping()
    UserResponse createUser(@RequestBody CreateUserRequest request) {
        return createUserInteractor.createUser(request);
    }

    @GetMapping("/")
    UserResponse getUser(@RequestParam String email) {
        return getUserInteractor.getUser(email);
    }

    @GetMapping
    List<UserResponse> getUsers() {
        return getUsersInteractor.getUsers();
    }

    @PostMapping("/login")
    String login(@RequestBody LoginUserRequest loginUserRequest) {
        return loginUserInteractor.login(loginUserRequest.email(), loginUserRequest.password());
    }
}
