package com.montrack.Montrack.users.controller;

import com.montrack.Montrack.response.Response;
import com.montrack.Montrack.users.dto.PinSetupRequestDto;
import com.montrack.Montrack.users.dto.RegisterRequestDto;
import com.montrack.Montrack.users.service.UserService;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Validated
@Log
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto registerRequestDto) {
        return Response.success("User registered successfully", userService.register(registerRequestDto));
    }

    @GetMapping("/profile")
    public ResponseEntity<?> profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        log.info("User profile requested for user: " + username);
        return Response.success("User profile", userService.findByEmail(username));
    }

    @PostMapping("/setup-pin")
    public String setupPin(@Validated @RequestBody PinSetupRequestDto request, Authentication authentication) {
        String username = authentication.getName();
        userService.setupPin(username, request.getPin(), request.getReconfirmPin());
        return "PIN setup successful";
    }
}