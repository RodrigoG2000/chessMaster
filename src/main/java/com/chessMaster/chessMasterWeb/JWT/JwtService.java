package com.chessMaster.chessMasterWeb.JWT;

import com.chessMaster.chessMasterWeb.UserModel.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    private static final String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(),user);
    }

    private String getToken(Map<String,Object> extraClaims, UserDetails user) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(SignatureAlgorithm.HS256, getKey())
                .compact();

    }
    private Key getKey(){
        return null;
    }
}