package com.example.emantranabackend.JWT;

import com.example.emantranabackend.Model.Admin;
import com.example.emantranabackend.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService{
    @Autowired
    AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<Admin> user=adminRepository.findByUserId(userId);
        user.orElseThrow(()->new UsernameNotFoundException("Not Found"));
        return user.map(MyUserDetail::new).get();
    }
}
