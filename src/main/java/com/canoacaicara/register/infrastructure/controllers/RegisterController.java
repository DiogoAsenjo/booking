package com.canoacaicara.register.infrastructure.controllers;

import com.canoacaicara.common.ApiReponse;
import com.canoacaicara.register.application.usecases.CreateRegisterInteractor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registers")
public class RegisterController {
    private final CreateRegisterInteractor createRegisterInteractor;

    public RegisterController(CreateRegisterInteractor createRegisterInteractor) {
        this.createRegisterInteractor = createRegisterInteractor;
    }

    @PostMapping()
    ResponseEntity<ApiReponse<RegisterResponse>> createRegister(@Valid @RequestBody CreateRegisterRequest request /*@RequestHeader("Authorization") String token*/) throws Exception {
        String token = "1234";
        ApiReponse<RegisterResponse> response = new ApiReponse<>("Register created", createRegisterInteractor.createRegister(request, token));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
