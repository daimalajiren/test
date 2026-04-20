package com.example.utils;




import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET_KEY = "MAxinwei123456";
    private static final long EXPIRE = 1000 * 60 * 60 * 24;
    /**
     * 生成JWT令牌
     *
     * @param claims   自定义数据

     * @return JWT令牌
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE ))
                .compact();
    }

    /**
     * 解析JWT令牌
     *
     * @param token JWT令牌
     */
    public static void parseJwt(String token) {
        Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
