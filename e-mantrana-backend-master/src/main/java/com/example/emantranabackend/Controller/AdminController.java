package com.example.emantranabackend.Controller;

import com.example.emantranabackend.DTO.DoctorRegistrationRequestDTO;
import com.example.emantranabackend.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/e-mantrana/api/admin")
@RestController
@CrossOrigin
public class AdminController {
    private final AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(value = "/add_doctor")
    public void addDepartment(@RequestBody DoctorRegistrationRequestDTO doctor){
        adminService.addDoctor(doctor);
    }

    @PatchMapping("/update_doctor/{email}")
    public ResponseEntity<String> updateDoctor(@PathVariable String email, @RequestBody Map<String,Object> fields){
        return adminService.updateDoctor(email,fields);
    }

    @DeleteMapping("/delete_doctor/{email}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String email){
        return adminService.deleteDoctor(email);
    }
}
