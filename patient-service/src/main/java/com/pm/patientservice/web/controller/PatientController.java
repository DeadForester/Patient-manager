package com.pm.patientservice.web.controller;

import com.pm.patientservice.service.PatientService;
import com.pm.patientservice.web.dto.PatientRequestDTO;
import com.pm.patientservice.web.dto.PatientResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        List<PatientResponseDTO> allPatients = patientService.getAllPatients();
        return ResponseEntity.ok().body(allPatients);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(patientResponseDTO);
    }
}
