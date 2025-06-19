package com.example.SaborYAlma.services;

import com.example.SaborYAlma.helper.APIMensajes;
import com.example.SaborYAlma.model.Carrito;
import com.example.SaborYAlma.repository.ICarritoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServicio {

    @Autowired
    ICarritoRepositorio repositorio;


    //Guardar carrito
    public Carrito guardarCarrito(Carrito datosCarrito) throws Exception {
        try {
            return this.repositorio.save(datosCarrito);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar todos
    public List<Carrito> listaCarritos() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar por ID
    public Carrito buscarCarritoPorId(Integer id) throws Exception {
        try {
            Optional<Carrito> carritoBuscado = this.repositorio.findById(id);
            if (carritoBuscado.isPresent()) {
                return carritoBuscado.get();
            } else {
                throw new Exception(APIMensajes.ERROR_CARRITO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Actualizar/modificar
    public Carrito actualizarCarrito(Integer id, Carrito nuevosDatosCarrito) throws Exception {
        try {
            Optional<Carrito> carritoBuscadoParaActualizar = this.repositorio.findById(id);
            if (carritoBuscadoParaActualizar.isPresent()) {
                carritoBuscadoParaActualizar.get().setEstado(nuevosDatosCarrito.getEstado());
                return this.repositorio.save(carritoBuscadoParaActualizar.get());
            } else {
                throw new Exception(APIMensajes.ERROR_CARRITO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar
    public Boolean eliminarCarrito(Integer id) throws Exception{
        try {
            Optional<Carrito> carritoBuscado = this.repositorio.findById(id);
            if (carritoBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_CARRITO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
