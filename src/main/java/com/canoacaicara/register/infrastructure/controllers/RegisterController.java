package com.canoacaicara.register.infrastructure.controllers;

import com.canoacaicara.common.ApiReponse;
import com.canoacaicara.register.application.usecases.CreateRegisterInteractor;
import com.canoacaicara.register.application.usecases.GetRegisterInteractor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registers")
public class RegisterController {
    private final CreateRegisterInteractor createRegisterInteractor;
    private final GetRegisterInteractor getRegisterInteractor;

    public RegisterController(CreateRegisterInteractor createRegisterInteractor, GetRegisterInteractor getRegisterInteractor) {
        this.createRegisterInteractor = createRegisterInteractor;
        this.getRegisterInteractor = getRegisterInteractor;
    }

    @PostMapping()
    ResponseEntity<ApiReponse<RegisterResponse>> createRegister(@Valid @RequestBody CreateRegisterRequest request, @RequestHeader("Authorization") String token) throws Exception {
        ApiReponse<RegisterResponse> response = new ApiReponse<>("Register created", createRegisterInteractor.createRegister(request, token));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    ResponseEntity<ApiReponse<List<RegisterResponse>>> getRegisters(@RequestHeader("Authorization") String token) {
        ApiReponse<List<RegisterResponse>> response = new ApiReponse<>("Registers found", getRegisterInteractor.getRegisters(token));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
