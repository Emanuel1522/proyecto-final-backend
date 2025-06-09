package com.example.SaborYAlma.services;

import com.example.SaborYAlma.helper.APIMensajes;
import com.example.SaborYAlma.models.Plato;
import com.example.SaborYAlma.repository.IPlatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServicio {

    @Autowired
    IPlatoRepositorio repositorio;

    //Guardar carrito
    public Plato guardarPlato(Plato datosPlato) throws Exception {
        try {
            return this.repositorio.save(datosPlato);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar todos
    public List<Plato> listaPlato() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar por ID
    public Plato buscarPlatoPorId(Integer id) throws Exception {
        try {
            Optional<Plato> platoBuscado = this.repositorio.findById(id);
            if (platoBuscado.isPresent()) {
                return platoBuscado.get();
            } else {
                throw new Exception(APIMensajes.ERROR_PLATO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Actualizar/modificar
    public Plato actualizarPlato(Integer id, Plato nuevosDatosPlato) throws Exception {
        try {
            Optional<Plato> platoBuscadoParaActualizar = this.repositorio.findById(id);
            if (platoBuscadoParaActualizar.isPresent()) {
                platoBuscadoParaActualizar.get().setNombre(nuevosDatosPlato.getNombre());
                platoBuscadoParaActualizar.get().setImagen(nuevosDatosPlato.getImagen());
                platoBuscadoParaActualizar.get().setDescripcion(nuevosDatosPlato.getDescripcion());
                platoBuscadoParaActualizar.get().setPrecio(nuevosDatosPlato.getPrecio());
                return this.repositorio.save(platoBuscadoParaActualizar.get());
            } else {
                throw new Exception(APIMensajes.ERROR_PLATO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar
    public Boolean eliminarPlato(Integer id) throws Exception{
        try {
            Optional<Plato> platoBuscado = this.repositorio.findById(id);
            if (platoBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_PLATO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}