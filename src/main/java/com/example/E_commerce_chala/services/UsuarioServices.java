package com.example.E_commerce_chala.services;

import com.example.E_commerce_chala.models.Usuario;
import com.example.E_commerce_chala.repository.IDUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {

    @Autowired
    IDUsuarioRepository usuarioRepository;

    //Guardado de usuario

    public Usuario crearUsuario(Usuario usuario) throws Exception {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new Exception("Error creando usuario: " + e.getMessage());
        }
    }

    public List<Usuario> buscarTodosLosUsuarios() throws Exception {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error buscando usuarios: " + e.getMessage());
        }
    }

    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        try {
            Optional<Usuario> buscar = usuarioRepository.findById(id);
            if (buscar.isPresent()) {
                return buscar.get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public Usuario modificarUsuarioPorId(Integer id, Usuario datos) throws Exception {
        try {
            Optional<Usuario> buscar = usuarioRepository.findById(id);
            if (buscar.isPresent()) {
                Usuario usuarioExistente = buscar.get();
                usuarioExistente.setNombre(datos.getNombre());
                usuarioExistente.setCorreoElectronico(datos.getCorreoElectronico());
                usuarioExistente.setContrasena(datos.getContrasena());
                // lo que más tengas en tu modelo...

                return usuarioRepository.save(usuarioExistente);
            } else {
                throw new Exception("Usuario no encontrado para actualizar");
            }
        } catch (Exception e) {
            throw new Exception("Error actualizando usuario: " + e.getMessage());
        }
    }

    public boolean eliminarUsuario(Integer id) throws Exception {
        try {
            Optional<Usuario> buscar = usuarioRepository.findById(id);
            if (buscar.isPresent()) {
                usuarioRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("Usuario no encontrado para eliminar");
            }
        } catch (Exception e) {
            throw new Exception("Error eliminando usuario: " + e.getMessage());
        }
    }
}
