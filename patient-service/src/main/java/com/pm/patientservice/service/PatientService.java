package com.pm.patientservice.service;

import com.pm.patientservice.entity.Patient;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.repository.PatientRepository;
import com.pm.patientservice.web.dto.PatientRequestDTO;
import com.pm.patientservice.web.dto.PatientResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with this email " +
                    "already exists " + patientRequestDTO.getEmail());
        }

        Patient newPatient = patientRepository.save(
                PatientMapper.toEntity(patientRequestDTO)
        );

        return PatientMapper.toDTO(newPatient);
    }
}
