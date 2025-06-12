package com.example.SaborYAlma.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "carritos")
public class Carrito {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Integer id;

    private Boolean estado = true;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;



    //Relacion con cliente N-1
    @ManyToOne
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id_cliente")
    @JsonBackReference(value="carritocliente")
    private Cliente cliente;

    //Relacion con carrito_items 1-N
    @OneToMany(mappedBy = "carrito")
    @JsonManagedReference(value="carritoItemCarrito")
    private List<CarritoItem> carritoItems;



    public Carrito() {
    }

    public Carrito(Integer id, Boolean estado, LocalDateTime fechaCreacion) {
        this.id = id;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<CarritoItem> getCarritoItems() {
        return carritoItems;
    }

    public void setCarritoItems(List<CarritoItem> carritoItems) {
        this.carritoItems = carritoItems;
    }
}