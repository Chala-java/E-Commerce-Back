package com.example.E_commerce_chala.controller;

import com.example.E_commerce_chala.models.Carrito;
import com.example.E_commerce_chala.services.CarritoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")  // Permite CORS solo para este controlador
@RequestMapping("/carrito")
public class ControllerCarrito {

    @Autowired
    CarritoServices carritoService;

    @PostMapping
    public ResponseEntity<?> crearCarrito(@RequestBody Carrito carrito) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(carritoService.crearCarrito(carrito));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarCarritos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carritoService.buscarTodosLosCarritos());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCarritoPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carritoService.buscarCarritoPorId(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrito(@PathVariable Integer id, @RequestBody Carrito carrito) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carritoService.modificarCarritoPorId(id, carrito));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCarrito(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carritoService.eliminarCarrito(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
