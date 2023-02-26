package com.example.emantranabackend.Service;

import com.example.emantranabackend.DTO.DoctorRegistrationRequestDTO;
import com.example.emantranabackend.Repository.AdminInterface;
import com.example.emantranabackend.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class AdminService {
    private final AdminInterface adminInterface;
    private final DoctorRepo doctorRepo;

    @Autowired
    public AdminService(@Qualifier("admin1") AdminInterface adminInterface, DoctorRepo doctorRepo) {
        this.adminInterface = adminInterface;
        this.doctorRepo = doctorRepo;

    }
    @Transactional
    public void addDoctor(DoctorRegistrationRequestDTO doctorRegistrationRequestDTO){
        if( doctorRepo.findByEmail(doctorRegistrationRequestDTO.getEmail()) != null){
            throw new IllegalStateException("Email already taken");
        }
        else {
            adminInterface.addDoctor(doctorRegistrationRequestDTO);
        }
    }

    @Transactional
    public ResponseEntity<String> updateDoctor(String email, Map<String, Object> fields) {
        var existingDoctor=doctorRepo.findByEmail(email);
        if(existingDoctor==null){
            throw new IllegalStateException("Doctor with email "+email+" does not exist");
        }
        fields.forEach((k,v)->{
            switch (k){
                case "fname":
                    existingDoctor.setFname((String) v);
                    break;
                case "lname":
                    existingDoctor.setLname((String) v);
                    break;
                case "type":
                    existingDoctor.setType((String) v);
                    break;
                case "ph_number":
                    existingDoctor.setPh_number((String) v);
                    break;
                default:
                    throw new IllegalStateException("Field "+k+" does not exist");
            }
        });
        doctorRepo.save(existingDoctor);
        return ResponseEntity.ok("Doctor with email "+email+" updated successfully");
    }

    public ResponseEntity<String> deleteDoctor(String email) {
        var existingDoctor=doctorRepo.findByEmail(email);
        if(existingDoctor==null){
            throw new IllegalStateException("Doctor with email "+email+" does not exist");
        }
        doctorRepo.delete(existingDoctor);
        return ResponseEntity.ok("Doctor with email "+email+" deleted successfully");
    }


}
