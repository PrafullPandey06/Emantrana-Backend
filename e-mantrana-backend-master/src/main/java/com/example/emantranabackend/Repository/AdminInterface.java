package com.example.emantranabackend.Repository;

import com.example.emantranabackend.DTO.DoctorRegistrationRequestDTO;

public interface AdminInterface {
    boolean addDoctor(DoctorRegistrationRequestDTO doctor);
}
