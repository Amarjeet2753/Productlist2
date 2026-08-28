package com.example.product.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.function.Function;


@Component
public class JwtUtil {

    private static String secretKey;
    public JwtUtil(){
        SecureRandom random =  new SecureRandom();
        byte key[] = new byte[32];
        random.nextBytes(key);
        secretKey = Base64.getEncoder().encodeToString(key);
    }

    public String generateToken(String usename, List<String> roles){

        return Jwts.builder().setSubject(usename)
                .claim("roles",roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*5))
                .signWith(getSignedKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public boolean isValidToken(String token, String username){
        return  (extractUserName(token).equals(username) && !isTokenExpired(token));
    }

    public String extractUserName(String token){
        return  extractClaim(token, Claims::getSubject);
    }
    public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }
    public  boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public List<String> extractRoles(String token){
        return extractClaim(token,claims->claims.get("roles",List.class));
    }

    public <T>  T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = Jwts.parser()
                .setSigningKey(getSignedKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    private Key getSignedKey(){
         byte[] keybytes = Decoders.BASE64.decode(secretKey);
         return Keys.hmacShaKeyFor(keybytes);
    }
}
