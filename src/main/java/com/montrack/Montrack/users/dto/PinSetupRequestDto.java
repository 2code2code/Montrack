package com.montrack.Montrack.users.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PinSetupRequestDto {
    @NotNull
    @Pattern
            (regexp = "\\d{6}", message = "PIN must be exactly 6 digits")
    private String pin;

    @NotNull
    @Pattern
            (regexp = "\\d{6}", message = "Reconfirmed PIN must be exactly 6 digits")
    private String reconfirmPin;
}
