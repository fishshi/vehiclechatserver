package com.vehiclechatserver.utils;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Jwt工具类
 */
public class JwtUtils {
    /**
     * 签名密钥
     */
    private static final SecretKey signKey = Keys.hmacShaKeyFor("SIGNKEY_OF_VEHICLECHATSERVER_SYSTEM".getBytes());

    /**
     * 令牌过期时间，单位：秒
     */
    private static final Long expire = 60 * 60 * 24L;

    /**
     * 生成Jwt令牌
     * 
     * @param claims Jwt令牌中包含的自定义声明内容
     * @return Jwt令牌
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .claims()
                .add(claims)
                .and()
                .expiration(Date.from(Instant.now().plusSeconds(expire)))
                .signWith(signKey, Jwts.SIG.HS256)
                .compact();
    }

    /**
     * 解析Jwt令牌
     * 
     * @param jwt Jwt令牌
     * @return Jwt令牌中包含的自定义声明内容
     */
    public static Claims parseJwt(String jwt) {
        return Jwts.parser()
                .verifyWith(signKey)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }
}