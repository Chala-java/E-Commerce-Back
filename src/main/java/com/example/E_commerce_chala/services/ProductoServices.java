package com.example.E_commerce_chala.services;


import com.example.E_commerce_chala.models.Producto;
import com.example.E_commerce_chala.repository.IDProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServices {

@Autowired
IDProductoRepository repository;


    public Producto guardarProducto (Producto datosProducto) throws Exception{
        try {
           return  this.repository.save(datosProducto);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List <Producto> buscartodosProductos () throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Producto buscarProductoPorId (Integer idProducto) throws Exception{
        try {
            Optional <Producto> buscarProducto = this.repository.findById(idProducto);
            if (buscarProducto.isPresent()){
                return buscarProducto.get();
            }else {
                throw new Exception("producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Producto modificarProductoPorId (Integer idProducto, Producto datosProducto) throws Exception {
        try {
            // Paso 1: Buscar el producto por su ID
            Optional<Producto> buscarProducto = this.repository.findById(idProducto);

            // Paso 2: Verificamos si lo encontró
            if (buscarProducto.isPresent()) {
                // Paso 3: Obtenemos el objeto Producto que ya está en la base de datos
                Producto productoExistente = buscarProducto.get();

                // Paso 4: Actualizamos los campos necesarios
                productoExistente.setProducto_cantidad(datosProducto.getProducto_cantidad());
                productoExistente.setProducto_categoria(datosProducto.getProducto_categoria());
                productoExistente.setProducto_nombre(datosProducto.getProducto_nombre());
                productoExistente.setProducto_marca(datosProducto.getProducto_marca());
                productoExistente.setProducto_imagen(datosProducto.getProducto_imagen());
                productoExistente.setProducto_fecha(datosProducto.getProducto_fecha());
                productoExistente.setProducto_precio(datosProducto.getProducto_precio());

                // Paso 5: Guardamos los cambios en la base de datos
                return this.repository.save(productoExistente);
            } else {
                throw new Exception("Producto no encontrado");
            }
        } catch (Exception error) {
            // Paso 6: Capturamos cualquier error inesperado
            throw new Exception(error.getMessage());
        }
    }



    public boolean eliminarProducto (Integer id) throws Exception{
        try {
            Optional<Producto> buscarProducto = this.repository.findById(id);
            if (buscarProducto.isPresent()) {
                this.repository.deleteById(id);
                return true;
            }else {
                throw new Exception("usuario no encontrado");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

























































}
