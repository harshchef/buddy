package com.aiknowledge.buddy.utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // secure random 256-bit key
    private static final String SECRET = "replace-with-a-very-long-secret-key-for-jwt-signing-1234567890";
    private static final SecretKey secretKey     = Keys.hmacShaKeyFor(SECRET.getBytes());
    private final long validityInMilliseconds = 3600_000; // 1 hour

    public String generateToken(Long userId) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey)
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        String subject = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        return Long.parseLong(subject);
    }
}
