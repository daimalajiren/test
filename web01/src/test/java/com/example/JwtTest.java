package com.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
//    @Test
//    public void testGenerateJwt() {
//        Map<String, Object> dataMap = new HashMap<>();
//        dataMap.put("id", 1);
//        dataMap.put("username", "admin");
//        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "TUF4aW53ZWkxMjM0NTY=")
//                .addClaims(dataMap)
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
//                .compact();
//        System.out.println(jwt);
//    }

//    @Test
//    public void testParseJwt() {
//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc3NjY3MzY1OX0.GkS7ASbyZJPj_KG-1BwsvTquMDdu5upDrWoN9odIYP4";
//        Claims claims = Jwts.parser().setSigningKey("TUF4aW53ZWkxMjM0NTY=")
//                .parseClaimsJws(token)
//                .getBody();
//        System.out.println(claims);
//    }
}
