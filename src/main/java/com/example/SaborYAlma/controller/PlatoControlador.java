package com.example.SaborYAlma.controller;

import com.example.SaborYAlma.models.Plato;
import com.example.SaborYAlma.services.PlatoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plato")
public class PlatoControlador {
    @Autowired
    PlatoServicio servicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Plato datosEnviados){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarPlato(datosEnviados));
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
            List<Plato> lista = this.servicio.listaPlato();
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
                    .body(this.servicio.buscarPlatoPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }


    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Plato nuevosDatosPlato) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.actualizarPlato(id, nuevosDatosPlato));
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
            if (this.servicio.eliminarPlato(id)) {
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .build();
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se pudo eliminar el pedido.");
            }
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }
}