package com.montrack.Montrack.users.dto;


import com.montrack.Montrack.users.entity.Users;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequestDto {

    @NotBlank(message = "Name is requiered")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    public Users toEntity() {
        Users user = new Users();
        user.setDisplayName(name);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
