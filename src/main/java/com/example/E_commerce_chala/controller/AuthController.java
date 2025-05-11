package com.example.E_commerce_chala.controller;


import com.example.E_commerce_chala.dto.LoginRequestDTO;
import com.example.E_commerce_chala.dto.LoginResponseDTO;
import com.example.E_commerce_chala.models.Usuario;
import com.example.E_commerce_chala.security.JwtUtils;
import com.example.E_commerce_chala.services.UsuarioServices;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UsuarioServices usuarioServices;
    @Autowired JwtUtils jwtUtils;

   @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) throws Exception{
       Usuario usuario = usuarioServices.validarCredenciales(request.getCorreoElectronico(),request.getContrasena());
       String token = jwtUtils.generarToken(usuario.getCorreoElectronico());

       return new  LoginResponseDTO (usuario.getNombre(),usuario.getCorreoElectronico(),token);
   }
}
