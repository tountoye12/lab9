package com.diallo.lab9.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.time.Instant;

@Service
public class JwtUtilityService {



    public static void main(String[] args) {
        // to make a new secret key
        System.out.println(Encoders.BASE64.encode(Jwts.SIG.HS256.key().build().getEncoded()));
    }
    private static final String SECRET = "M0g9JhdFu8bMfnkbywETmTmhtuTI+3XYBt20zQqK4w0=";
    private SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));

    public String generateToken(String username, String[] roles) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        var now = Instant.now();
        return Jwts.builder()
                .claims()
                .subject(username)
                .add(claims)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(24, ChronoUnit.HOURS)))
                .and()
                .signWith(key)
                .compact();
    }

    // Claims implements Map<String, Object> allowing users to easily extract the claims
    public Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }
}
