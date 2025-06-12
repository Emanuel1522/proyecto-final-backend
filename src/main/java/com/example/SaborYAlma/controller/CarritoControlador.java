package com.example.SaborYAlma.controller;

import com.example.SaborYAlma.models.Carrito;
import com.example.SaborYAlma.services.CarritoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoControlador {
    @Autowired
    CarritoServicio servicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Carrito datosEnviados){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarCarrito(datosEnviados));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }


    // Buscar todos
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            List<Carrito> lista = this.servicio.listaCarritos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(lista);
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }



    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarCarritoPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }



    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Carrito nuevosDatos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.actualizarCarrito(id, nuevosDatos));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }



    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            if (this.servicio.eliminarCarrito(id)) {
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .build();
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se pudo eliminar el carrito.");
            }
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }
}
