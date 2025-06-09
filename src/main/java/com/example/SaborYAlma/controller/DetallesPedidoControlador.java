package com.example.SaborYAlma.controller;

import com.example.SaborYAlma.models.DetallesPedido;
import com.example.SaborYAlma.services.DetallesPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalles_pedidos")
public class DetallesPedidoControlador {
    @Autowired
    DetallesPedidoServicio servicio;

    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody DetallesPedido datosEnviados){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarDetallesPedido(datosEnviados));
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