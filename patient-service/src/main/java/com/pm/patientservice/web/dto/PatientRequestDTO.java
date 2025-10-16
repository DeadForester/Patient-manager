package com.pm.patientservice.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name can't exceed 100 characters")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Address is required")
    private String dateOfBirth;

    @NotNull(message = "Registered date is required")
    private String registeredDate;
}
