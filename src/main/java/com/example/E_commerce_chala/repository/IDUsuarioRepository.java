package com.example.E_commerce_chala.repository;

import com.example.E_commerce_chala.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IDUsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);

}
