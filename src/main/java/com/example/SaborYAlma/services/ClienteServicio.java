package com.example.SaborYAlma.services;

import com.example.SaborYAlma.helper.APIMensajes;
import com.example.SaborYAlma.model.Cliente;
import com.example.SaborYAlma.repository.IClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    IClienteRepositorio repositorio;


    //Guardar carrito
    public Cliente guardarCliente(Cliente datosCliente) throws Exception {
        try {
            return this.repositorio.save(datosCliente);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar todos
    public List<Cliente> listaClientes() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Buscar por ID
    public Cliente buscarClientePorId(Integer id) throws Exception {
        try {
            Optional<Cliente> clienteBuscado = this.repositorio.findById(id);
            if (clienteBuscado.isPresent()) {
                return clienteBuscado.get();
            } else {
                throw new Exception(APIMensajes.ERROR_CLIENTE_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Actualizar/modificar
    public Cliente actualizarCliente(Integer id, Cliente nuevosDatosCliente) throws Exception {
        try {
            Optional<Cliente> clienteBuscadoParaActualizar = this.repositorio.findById(id);
            if (clienteBuscadoParaActualizar.isPresent()) {
                clienteBuscadoParaActualizar.get().setNombre(nuevosDatosCliente.getNombre());
                clienteBuscadoParaActualizar.get().setApellido(nuevosDatosCliente.getApellido());
                clienteBuscadoParaActualizar.get().setCorreo(nuevosDatosCliente.getCorreo());
                clienteBuscadoParaActualizar.get().setContraseña(nuevosDatosCliente.getContraseña());
                return this.repositorio.save(clienteBuscadoParaActualizar.get());
            } else {
                throw new Exception(APIMensajes.ERROR_CLIENTE_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Eliminar
    public Boolean eliminarCliente(Integer id) throws Exception{
        try {
            Optional<Cliente> clienteBuscado = this.repositorio.findById(id);
            if (clienteBuscado.isPresent()) {
                this.repositorio.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMensajes.ERROR_CLIENTE_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
