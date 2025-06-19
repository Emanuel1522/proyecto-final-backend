package com.example.SaborYAlma.services;

import com.example.SaborYAlma.helper.APIMensajes;
import com.example.SaborYAlma.model.CarritoItem;
import com.example.SaborYAlma.repository.ICarritoItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoItemServicio {

    @Autowired
    ICarritoItemRepositorio repositorio;


    //Guardar carrito
    public CarritoItem guardarCarritoItem(CarritoItem datosCarritoItem) throws Exception {
        try {
            return this.repositorio.save(datosCarritoItem);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar todos
    public List<CarritoItem> listaCarritoItem() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar por ID
    public CarritoItem buscarCarritoItemPorId(Integer id) throws Exception {
        try {
            Optional<CarritoItem> carritoItemBuscado = this.repositorio.findById(id);
            if (carritoItemBuscado.isPresent()) {
                return carritoItemBuscado.get();
            } else {
                throw new Exception(APIMensajes.ERROR_CARRITO_ITEM_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Actualizar/modificar
    public CarritoItem actualizarCarritoItem(Integer id, CarritoItem nuevosDatosCarritoItem) throws Exception {
        try {
            Optional<CarritoItem> carritoItemBuscadoParaActualizar = this.repositorio.findById(id);
            if (carritoItemBuscadoParaActualizar.isPresent()) {
                carritoItemBuscadoParaActualizar.get().setCantidad(nuevosDatosCarritoItem.getCantidad());
                return this.repositorio.save(carritoItemBuscadoParaActualizar.get());
            } else {
                throw new Exception(APIMensajes.ERROR_CARRITO_ITEM_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar
    public Boolean eliminarCarritoItem(Integer id) throws Exception{
        try {
            Optional<CarritoItem> carritoItemBuscado = this.repositorio.findById(id);
            if (carritoItemBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_CARRITO_ITEM_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
