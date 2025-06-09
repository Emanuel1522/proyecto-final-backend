package com.example.SaborYAlma.services;

import com.example.SaborYAlma.helper.APIMensajes;
import com.example.SaborYAlma.models.DetallesPedido;
import com.example.SaborYAlma.repository.IDetallesPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallesPedidoServicio {

    @Autowired
    IDetallesPedidoRepositorio repositorio;

    //Guardar carrito
    public DetallesPedido guardarDetallesPedido(DetallesPedido datosDetallesPedido) throws Exception {
        try {
            return this.repositorio.save(datosDetallesPedido);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar todos
    public List<DetallesPedido> listaDetallesPedidos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar por ID
    public DetallesPedido buscarDetallesPedidoPorId(Integer id) throws Exception {
        try {
            Optional<DetallesPedido> detallesPedidoBuscado = this.repositorio.findById(id);
            if (detallesPedidoBuscado.isPresent()) {
                return detallesPedidoBuscado.get();
            } else {
                throw new Exception(APIMensajes.ERROR_DETALLES_PEDIDO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Actualizar/modificar
    public DetallesPedido actualizarDetallesPedido(Integer id, DetallesPedido nuevosDatosDetallesPedido) throws Exception {
        try {
            Optional<DetallesPedido> detallesPedidoBuscadoParaActualizar = this.repositorio.findById(id);
            if (detallesPedidoBuscadoParaActualizar.isPresent()) {
                detallesPedidoBuscadoParaActualizar.get().setCantidad(nuevosDatosDetallesPedido.getCantidad());
                return this.repositorio.save(detallesPedidoBuscadoParaActualizar.get());
            } else {
                throw new Exception(APIMensajes.ERROR_DETALLES_PEDIDO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar
    public Boolean eliminarDetallesPedido(Integer id) throws Exception{
        try {
            Optional<DetallesPedido> detallesPedidoBuscado = this.repositorio.findById(id);
            if (detallesPedidoBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_DETALLES_PEDIDO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}