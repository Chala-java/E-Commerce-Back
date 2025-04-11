package com.example.E_commerce_chala.controller;

import com.example.E_commerce_chala.models.Producto;
import com.example.E_commerce_chala.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/productos")
public class ControllerProducto {

    @Autowired
    ProductoServices productoServices;

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        try {
            producto.setProducto_fecha(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(productoServices.guardarProducto(producto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarProductos() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productoServices.buscartodosProductos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProductoPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productoServices.buscarProductoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(productoServices.modificarProductoPorId(id, producto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        try {
            productoServices.eliminarProducto(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
