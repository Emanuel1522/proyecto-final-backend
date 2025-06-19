package com.example.SaborYAlma.services;

import com.example.SaborYAlma.helper.APIMensajes;
import com.example.SaborYAlma.model.Pedido;
import com.example.SaborYAlma.repository.IPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {

    @Autowired
    IPedidoRepositorio repositorio;


    //Guardar carrito
    public Pedido guardarPedido(Pedido datosPedido) throws Exception {
        try {
            return this.repositorio.save(datosPedido);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar todos
    public List<Pedido> listaPedidos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar por ID
    public Pedido buscarPedidoPorId(Integer id) throws Exception {
        try {
            Optional<Pedido> pedidoBuscado = this.repositorio.findById(id);
            if (pedidoBuscado.isPresent()) {
                return pedidoBuscado.get();
            } else {
                throw new Exception(APIMensajes.ERROR_PEDIDO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Actualizar/modificar
    public Pedido actualizarPedido(Integer id, Pedido nuevosDatosPedido) throws Exception {
        try {
            Optional<Pedido> pedidoBuscadoParaActualizar = this.repositorio.findById(id);
            if (pedidoBuscadoParaActualizar.isPresent()) {
                pedidoBuscadoParaActualizar.get().setEstado(nuevosDatosPedido.getEstado());
                pedidoBuscadoParaActualizar.get().setFecha(nuevosDatosPedido.getFecha());
                pedidoBuscadoParaActualizar.get().setDireccionEntrega(nuevosDatosPedido.getDireccionEntrega());
                pedidoBuscadoParaActualizar.get().setTelefono(nuevosDatosPedido.getTelefono());
                return this.repositorio.save(pedidoBuscadoParaActualizar.get());
            } else {
                throw new Exception(APIMensajes.ERROR_PEDIDO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar
    public Boolean eliminarPedido(Integer id) throws Exception{
        try {
            Optional<Pedido> pedidoBuscado = this.repositorio.findById(id);
            if (pedidoBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_PEDIDO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}