package com.example.SaborYAlma.controller;

import com.example.SaborYAlma.model.DetallesPedido;
import com.example.SaborYAlma.services.DetallesPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        try {
            List<DetallesPedido> lista = this.servicio.listaDetallesPedidos();
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
                    .body(this.servicio.buscarDetallesPedidoPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    // Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody DetallesPedido nuevosDatosDetallesPedido) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.actualizarDetallesPedido(id, nuevosDatosDetallesPedido));
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
            if (this.servicio.eliminarDetallesPedido(id)) {
                return ResponseEntity
                        .status(HttpStatus.NO_CONTENT)
                        .build();
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se pudo eliminar los detalles del pedido.");
            }
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(error.getMessage());
        }
    }
}