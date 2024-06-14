package com.montrack.Montrack.users.service.impl;

import com.montrack.Montrack.exception.ApplicationException;
import com.montrack.Montrack.users.dto.RegisterRequestDto;
import com.montrack.Montrack.users.entity.Users;
import com.montrack.Montrack.users.repository.UserRepository;
import com.montrack.Montrack.users.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users register(RegisterRequestDto user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ApplicationException("Email already in use");
        }
        Users newUser = user.toEntity();
        var password = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ApplicationException("User not found"));
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ApplicationException("User not found"));
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ApplicationException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public Users profile() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new ApplicationException("User not found"));
    }

    @Override
    @Transactional
    public void setupPin(String username, String pin, String reconfirmPin) {
        if (!pin.equals(reconfirmPin)) {
            throw new IllegalArgumentException("PINs do not match");
        }
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ApplicationException("User not found"));
        user.setPinHash(passwordEncoder.encode(pin));
        userRepository.save(user);
    }
}
