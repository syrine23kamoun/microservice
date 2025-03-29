package com.assurance.assuranceback.Entity.CarrieresEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JWTFilter  {

    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;



}
