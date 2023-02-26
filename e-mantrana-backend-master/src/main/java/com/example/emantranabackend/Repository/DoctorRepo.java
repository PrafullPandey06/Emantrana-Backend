package com.example.emantranabackend.Repository;

import com.example.emantranabackend.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
    public Doctor findByEmail(String email);
}
