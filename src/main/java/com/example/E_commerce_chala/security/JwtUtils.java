package com.example.E_commerce_chala.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {
  private  final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

  //Expiracion del token de un dia
  private  final long EXPIRATION_TIME = 86400000;

  public String generarToken(String email){
      return Jwts.builder()
              .subject(email)
              .setIssuedAt(new Date())
              .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
              .signWith(secretKey) // firma de la clave secreta
              .compact(); //el compact convierte en String
  }

  //Validacion del token
  public boolean validarToken(String token){
      try {
          Jwts.parser()
                  .verifyWith(secretKey)
                  .build()
                  .parseSignedClaims(token);
          return true;
      }catch (JwtException e){
          return false;
      }
  }

  public String extraerEmail(String token){
      //sin el build nada se ejecuta
      //
      Claims claims = Jwts.parser()
              .verifyWith(secretKey)
              .build()
              .parseSignedClaims(token)
              .getPayload();
      return claims.getSubject(); //aqui se recupera el email
  }


}
