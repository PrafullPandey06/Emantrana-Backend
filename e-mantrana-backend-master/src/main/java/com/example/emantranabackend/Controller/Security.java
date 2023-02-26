package com.example.emantranabackend.Controller;

import com.example.emantranabackend.JWT.JWTUtil;
import com.example.emantranabackend.Model.AdminAuthenticationRequest;
import com.example.emantranabackend.Model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class Security {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "/e-mantrana/admin/login",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken
            (@RequestBody AdminAuthenticationRequest authenticationRequest)
            throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserId(),
                            authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username and password",e);
        }
        final UserDetails userDetails= userDetailsService.loadUserByUsername(
                authenticationRequest.getUserId());

        final String jwt=jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
