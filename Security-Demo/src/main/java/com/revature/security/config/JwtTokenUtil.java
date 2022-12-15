package com.revature.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// This class will contain methods relating to the token itself, creating the token, validating it, and so on
@Component
public class JwtTokenUtil implements Serializable {

    // we only want the token to last for 5 hours
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    // getting the secret from the app.properties file:
    @Value("${jwt.secret}")
    private String secret;

    // given a token, return the claims
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    // given a token and a resolve, apply that resolver to the claims and return
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // get the username from the token:
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // check if token is expired:
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        // return whether or not the expiration comes before the current date/time:
        return expiration.before(new Date());
    }


    // A few things happening here
    // We set the claims, issue time and expiration time
    // issue time is right now, expiration is 5 hours from now
    // We sign the JWT using a certain algorithm and our secret key
    // Finally, we compact the token to a URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    // given a userdetails object, generate a token for that username
    public String generateToken(UserDetails userDetails) {
        Map<String,Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    // validate token
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        // make sure that usernames match and token is not expired
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }




}
