package com.montrack.Montrack.auth.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import java.time.Instant;
import java.util.stream.Collectors;

public interface AuthService {
    String generateToken(Authentication authentication) ;
//        Instant now = Instant.now();
//        String scope = authentication.getAuthorities()
//                .stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(" "));
//        String scope = authentication.getAuthorities()
//                .stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(" "));
//        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

}
