package com.example.SaborYAlma.controller;

import com.example.SaborYAlma.model.CarritoItem;
import com.example.SaborYAlma.services.CarritoItemServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito_item")
public class CarritoItemControlador {

    @Autowired
    CarritoItemServicio servicio;


    //Guardar
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody CarritoItem datosEnviados) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarCarritoItem(datosEnviados));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Buscar todos
    public ResponseEntity<?> buscarTodos() {
        try {
            List<CarritoItem> lista = this.servicio.listaCarritoItem();
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
                    .body(this.servicio.buscarCarritoItemPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody CarritoItem nuevosDatosCarritoItem) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.actualizarCarritoItem(id, nuevosDatosCarritoItem));
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
            if (this.servicio.eliminarCarritoItem(id)) {
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .build();
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se pudo eliminar el item del carrito.");
            }
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }
}
