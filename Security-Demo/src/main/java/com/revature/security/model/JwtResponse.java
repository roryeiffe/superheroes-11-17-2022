package com.revature.security.model;


import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class JwtResponse {
    // Simple model, just containing a token:
    private String jwttoken;
}
