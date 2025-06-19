package com.example.SaborYAlma.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "carrito_items")
public class CarritoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito_item")
    private Integer id;

    private Integer cantidad;


    //Relacion con carritos N-1
    @ManyToOne
    @JoinColumn(name = "fk_carrito", referencedColumnName = "id_carrito")
    @JsonBackReference(value="carritoItemCarrito")
    private Carrito carrito;

    //Relacion con platos N-1
    @ManyToOne
    @JoinColumn(name = "fk_plato", referencedColumnName = "id_plato")
    @JsonBackReference(value="carritoItemPlato")
    private Plato plato;


    public CarritoItem() {
    }

    public CarritoItem(Integer id, Integer cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}