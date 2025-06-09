package com.example.SaborYAlma.controller;

import com.example.SaborYAlma.models.Plato;
import com.example.SaborYAlma.services.PlatoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // Buscar por ID

    // Actualizar

    // Eliminar
}