package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;

@Service 
public class JWTservice {
    @Value("${security.jwt.secret-key}")
    private String secretKey;
    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;
    public String getUsernames(String token){
        return extractClaim(token, Claims::getSubject);
    }
    public <T> extractClaim(String token,Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
}   
