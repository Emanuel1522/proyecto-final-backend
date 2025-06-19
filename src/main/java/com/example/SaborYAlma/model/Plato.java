package com.example.SaborYAlma.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.example.SaborYAlma.helper.TipoPlato;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "platos")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plato")
    private Integer id;

    private String nombre;

    private String descripcion;

    private String imagen;

    private Double precio;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPlato tipo;


    //Relacion con carrito_items 1-N
    @OneToMany(mappedBy = "plato")
    @JsonManagedReference(value="carritoItemPlato")
    private List<CarritoItem> carritoItems;

    //Relacion con detalles_pedido 1-N
    @OneToMany(mappedBy = "plato")
    @JsonManagedReference(value="detallesPedidoPlato")
    private List<DetallesPedido> detallesPedidos;


    public Plato() {
    }

    public Plato(Integer id, String nombre, String descripcion, String imagen, Double precio, TipoPlato tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public List<CarritoItem> getCarritoItems() {
        return carritoItems;
    }

    public void setCarritoItems(List<CarritoItem> carritoItems) {
        this.carritoItems = carritoItems;
    }

    public List<DetallesPedido> getDetallesPedidos() {
        return detallesPedidos;
    }

    public void setDetallesPedidos(List<DetallesPedido> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }
}

