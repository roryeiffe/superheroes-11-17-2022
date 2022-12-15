package com.revature.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Generate some boiler plate code including getters, setters, no-arg constructor, all arg-constructor
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {
    // What fields do we need to pass in when we are requesting a JWT?
    // containing a username and password:
    private String username;
    private String password;
}
