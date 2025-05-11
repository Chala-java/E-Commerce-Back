package com.example.E_commerce_chala.dto;

public class LoginResponseDTO {

    private String nombre;
    private String correoElectronico;

    private String token;

    public LoginResponseDTO(){}

    public LoginResponseDTO(String nombre, String correoElectronico, String token) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.token = token;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
