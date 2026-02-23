package com.example.self_management.security.jwt;

import com.example.self_management.persistence.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = String.valueOf(Keys.secretKeyFor(SignatureAlgorithm.HS256));

    //Here, I generated a jwt token through a secret key. As well pass username and userId for generate token. set validate time in this token.
    public String generateToken(UserEntity userEntity) {
        return Jwts.builder()
                .setSubject(userEntity.getUsername()) //username pass
                .claim("userId", userEntity.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Long extractUserId(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("userId", Long.class);
    }

    public boolean isTokenValid(String token){
        try{
            extractUsername(token);
            return true;
        } catch(Exception e){
            return false;

        }
    }
}
