package com.montrack.Montrack.users.service;

import com.montrack.Montrack.users.dto.RegisterRequestDto;
import com.montrack.Montrack.users.entity.Users;

import java.util.List;

public interface UserService {

    Users register(RegisterRequestDto user);

    Users findByEmail(String email);

    Users findById(Long id);

    List<Users> findAll();

    void deleteById(Long id);

    Users profile();

    void setupPin(String username, String pin, String reconfirmPin);

}
